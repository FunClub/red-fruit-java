package com.taomei.redfruit.business.shared.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.application.repository.TrendNoticeRepository;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.SharedService;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.*;
import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import com.taomei.redfruit.business.shared.application.repository.DiscussionNoticeFlagRepository;
import com.taomei.redfruit.business.shared.application.repository.ParentDiscussionRepository;
import com.taomei.redfruit.business.shared.application.repository.SubDiscussionRepository;
import com.taomei.redfruit.business.shared.application.repository.ThumbRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.DiscussionNoticeFlag;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import com.taomei.redfruit.business.shared.infrastructure.po.Thumb;
import com.taomei.redfruit.business.trend.application.dto.QueryMoodComm;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 共享服务实现
 */
@Service
public class BaseSharedService implements SharedService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrendNoticeService noticeService;

    @Autowired
    private TrendNoticeRepository trendNoticeRepository;

    @Autowired
    private ParentDiscussionRepository parentDiscussionRepository;

    @Autowired
    private SubDiscussionRepository subDiscussionRepository;

    @Autowired
    private ThumbRepository thumbRepository;
    /**
     * 取消赞
     *
     * @param targetId 点赞目标 id
     * @param userId   点赞的用户 Id
     * @return 取消结果
     */
    @Override
    @Transactional
    public boolean deleteThumb(String targetId, String userId) {
        //删除点赞
        Thumb thumb = new Thumb();
        thumb.setTargetId(targetId);
        thumb.setUserId(userId);
        thumbRepository.delete(new EntityWrapper<>(thumb));

        //删除动态通知
        trendNoticeRepository.delete(new EntityWrapper<TrendNotice>()
                .eq("trend_id",targetId).
        eq("make_notice_user_id",userId).eq("trend_notice_type","赞")
        );
        return true;
    }

    /**
     * 点赞
     *
     * @return 点赞结果
     */
    @Override
    @Transactional
    public boolean createThumb(TrendNotice notice) {

        //插入点赞
        Thumb thumb = new Thumb();
        thumb.setTargetId(notice.getTrendId());
        thumb.setUserId(notice.getMakeNoticeUserId());
        thumbRepository.insert(thumb);

        //插入动态通知
        notice.setDate(TimeUtils.generateDateTimeString());
        noticeService.create(notice);
        return true;
    }

    /**
     * 插入子级评论
     * @param comm 子级评论命令
     * @return 子级评论信息
     */
    @Override
    @Transactional
    public SubDiscussionInfo insertSubDiscussion(InsertSubDiscussionComm comm) {
        TrendNotice notice = comm.getTrendNotice();
        SubDiscussion subDiscussion = comm.getSubDiscussion();

        //插入子评论
        subDiscussion.setDate(TimeUtils.generateDateTimeString());
        subDiscussionRepository.insert(subDiscussion);

        //查询该子评论的父评论是否已经拥有一个动态通知，如有则不插入动态通知，而是修改。
        String parentDiscussionId = subDiscussion.getParentDiscussionId();
        String discussedUserId = subDiscussion.getDiscussedUserId();

        TrendNotice queryTrendNotice = trendNoticeRepository.selectOne(new EntityWrapper<TrendNotice>()
                .eq("discussion_id",parentDiscussionId)
                .eq("notice_user_id",notice.getNoticeUserId())
                .eq("make_notice_user_id",notice.getMakeNoticeUserId())
                );
        if(queryTrendNotice==null){
            //插入动态通知
            notice.setDate(TimeUtils.generateDateTimeString());
            noticeService.create(notice);
        }else{
            //更新动态通知
            queryTrendNotice.setDate(TimeUtils.generateDateTimeString());
            queryTrendNotice.setMakeNoticeUserId(subDiscussion.getUserId());
            queryTrendNotice.setTrendNoticeContent(subDiscussion.getContent());
            queryTrendNotice.setState(false);
            trendNoticeRepository.updateById(queryTrendNotice);
        }

        //更新父级评论中子评论数量
        ParentDiscussion parentDiscussion = parentDiscussionRepository.selectById(parentDiscussionId);
        parentDiscussion.setSubDiscussionCount(parentDiscussion.getSubDiscussionCount()+1);
        parentDiscussionRepository.updateById(parentDiscussion);
        return DiscussionDtoAssembler.assembleSubDiscussionInfoForCreate(subDiscussion,userRepository);
    }

    /**
     * 查询父级评论
     * @param comm 查询评论
     * @return 分页的父级评论
     */
    @Override
    public PagedInfo selectParentDiscussionInfo(PageComm<ParentDiscussionInfo,QueryDiscussionComm> comm) {
        QueryDiscussionComm queryDiscussionComm = comm.getCondition();
        Page<ParentDiscussionInfo> page = comm.getPage();
        page= parentDiscussionRepository.selectByPage(page,queryDiscussionComm);

        return DiscussionDtoAssembler.assembleParentDiscussionPagedInfo(page,queryDiscussionComm,userRepository);
    }

    /**
     * 插入父级评论
     *
     * @param discussionComm 插入父级评论 命令
     * @return 父级评论信息
     */
    @Override
    @Transactional
    public ParentDiscussionInfo createParentDiscussion(InsertParentDiscussionComm discussionComm) {
        //插入父级评论
        ParentDiscussion discussion = discussionComm.getParentDiscussion();
        discussion.setDate(TimeUtils.generateDateTimeString());
        parentDiscussionRepository.insert(discussion);

        //插入通知动态
        TrendNotice notice = discussionComm.getTrendNotice();
        notice.setDate(TimeUtils.generateDateTimeString());
        notice.setDiscussionId(discussion.getParentDiscussionId());
        noticeService.create(notice);

        return DiscussionDtoAssembler.assembleParentDiscussionInfoForCreate(discussion,userRepository);
    }

    /**
     * 获取用户主页标题信息
     *
     * @param userId 用户Id
     * @return 标题信息
     */
    @Override
    public TitleUserInfo selectTitleUserInfo(String userId) {
        User user=userRepository.selectById(userId);
        TitleUserInfo info = new TitleUserInfo();
        BeanUtils.copyProperties(user,info);
        return info;
    }
}
