package com.taomei.redfruit.business.shared.application;

import com.taomei.redfruit.business.shared.application.dto.InsertParentDiscussionComm;
import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import org.springframework.stereotype.Service;

/**
 * 共享服务接口
 */
@Service
public interface SharedService {

    /**
     * 插入父级评论
     * @param discussionComm 插入父级评论 命令
     * @return 父级评论信息
     */
    ParentDiscussionInfo createParentDiscussion(InsertParentDiscussionComm discussionComm);
    /**
     * 获取用户主页标题信息
     * @param userId 用户Id
     * @return 标题信息
     */
    TitleUserInfo selectTitleUserInfo(String userId);
}
