package com.taomei.redfruit.business.message.application.dto;


import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import lombok.Data;

/**
 * 动态通知信息dto
 */
@Data
public class TrendNoticeInfo extends TrendNotice{

    /**
     * 简短时间
     */
    private String shortDate;

    /**
     * 分门别类时间
     */
    private String sortDate;

    /**
     * 生成此动态通知的用户简短信息
     */
    private UserShortInfo makeNoticeShortInfo;

    /**
     * 动态用户信息
     */
    private UserShortInfo trendUserInfo;
    /**
     * 父级评论信息
     */
    private ParentDiscussionInfo parentDiscussionInfo;
}
