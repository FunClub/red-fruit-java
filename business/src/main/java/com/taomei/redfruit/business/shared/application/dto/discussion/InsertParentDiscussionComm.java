package com.taomei.redfruit.business.shared.application.dto.discussion;

import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import lombok.Data;

/**
 * 插入父级评论 dto
 */
@Data
public class InsertParentDiscussionComm {

    /**
     * 动态通知
     */
    private TrendNotice trendNotice;

    /**
     * 子级评论
     */
    private ParentDiscussion parentDiscussion;
}
