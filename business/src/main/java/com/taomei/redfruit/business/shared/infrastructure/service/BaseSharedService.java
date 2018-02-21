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
import com.taomei.redfruit.business.shared.infrastructure.po.DiscussionNoticeFlag;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import com.taomei.redfruit.business.trend.application.dto.QueryMoodComm;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
                .eq("discussion_id",parentDiscussionId));
        if(queryTrendNotice==null){
            //插入动态通知
            notice.setDate(TimeUtils.generateDateTimeString());
            noticeService.create(notice);
        }else{
            //更新动态通知
            queryTrendNotice.setDate(TimeUtils.generateDateTimeString());
            queryTrendNotice.setMakeNoticeUserId(subDiscussion.getUserId());
            queryTrendNotice.setTrendContent(subDiscussion.getContent());
            queryTrendNotice.setState(false);
            trendNoticeRepository.updateById(queryTrendNotice);
        }

        //更新父级评论中子评论数量
        ParentDiscussion parentDiscussion = parentDiscussionRepository.selectById(parentDiscussionId);
        parentDiscussion.setSubDiscussionCount(parentDiscussion.getSubDiscussionCount()+1);
        return DiscussionDtoAssembler.AssembleSubDiscussionInfoForCreate(subDiscussion,userRepository);
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

        return DiscussionDtoAssembler.AssembleParentDiscussionPagedInfo(page,queryDiscussionComm,userRepository);
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

        return DiscussionDtoAssembler.AssembleParentDiscussionInfoForCreate(discussion,userRepository);
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
