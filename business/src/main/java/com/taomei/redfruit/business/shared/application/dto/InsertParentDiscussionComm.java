package com.taomei.redfruit.business.shared.application.dto;

import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import lombok.Data;

/**
 * 插入父级评论 dto
 */
@Data
public class InsertParentDiscussionComm {
    private TrendNotice trendNotice;
    private ParentDiscussion discussion;
}
