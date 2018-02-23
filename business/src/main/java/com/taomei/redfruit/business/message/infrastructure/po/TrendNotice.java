package com.taomei.redfruit.business.message.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 通知实体
 */
@Data
public class TrendNotice {

    /**
     * 通知 id
     */
    @TableId
    private String trendNoticeId;

    /**
     * 时间
     */
    private String date;

    /**
     * 动态通知所属用户 Id
     */
    private String noticeUserId;

    /**
     * 动态 Id
     */
    private String trendId;

    /**
     * 动态用户 Id
     */
    private String trendUserId;

    /**
     * 生成此动态通知的用户id
     */
    private String makeNoticeUserId;

    /**
     * 通知类型，点赞，评论，回复等
     */
    private String trendNoticeType;

    /**
     * 动态类型
     */
    private String trendType;

    /**
     * 通知是否已读
     */
    private boolean state;

    /**
     * 动态的内容
     */
    private String trendContent;

    /**
     * 通知的内容
     */
    private String trendNoticeContent;
    /**
     * 动态的图片
     */
    private String  trendImg;

    /**
     * 评论 id
     */
    private String discussionId;

}
