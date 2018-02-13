package com.taomei.redfruit.business.trend.infrastructure.po;

import lombok.Data;

/**
 * 基础动态类
 */
@Data
public class Trend {

    /**
     * 动态id
     */
    private String id;

    /**
     * 发表动态的用户id
     */
    private String userId;

    /**
     * 发布时间
     */
    private String date;

    /**
     * 点赞数
     */
    private Integer thumbCount;

    /**
     * 评论数
     */
    private Integer discussionCount;
}
