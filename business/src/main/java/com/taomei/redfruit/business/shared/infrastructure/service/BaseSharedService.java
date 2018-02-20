package com.taomei.redfruit.business.shared.infrastructure.service;

import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.SharedService;
import com.taomei.redfruit.business.shared.application.dto.InsertParentDiscussionComm;
import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import com.taomei.redfruit.business.shared.application.repository.ParentDiscussionRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseSharedService implements SharedService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrendNoticeService noticeService;

    @Autowired
    private ParentDiscussionRepository discussionRepository;

    /**
     * 插入父级评论
     *
     * @param discussionComm 插入父级评论 命令
     * @return 父级评论信息
     */
    @Override
    public ParentDiscussionInfo createParentDiscussion(InsertParentDiscussionComm discussionComm) {
        //插入父级评论
        ParentDiscussion discussion = discussionComm.getDiscussion();
        discussion.setDate(TimeUtils.generateDateTimeString());
        discussionRepository.insert(discussion);

        //插入通知动态
        TrendNotice notice = discussionComm.getTrendNotice();
        notice.setDate(TimeUtils.generateDateTimeString());
        notice.setDiscussionId(discussion.getParentDiscussionId());
        noticeService.create(notice);
        return null;
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
