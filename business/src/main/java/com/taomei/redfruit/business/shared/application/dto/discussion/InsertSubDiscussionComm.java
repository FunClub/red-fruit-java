package com.taomei.redfruit.business.shared.application.dto.discussion;

import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import lombok.Data;

/**
 * 插入子级评论 dto
 */
@Data
public class InsertSubDiscussionComm {

    /**
     * 动态通知
     */
    private TrendNotice trendNotice;

    /**
     * 子级评论
     */
    private SubDiscussion subDiscussion;
}
