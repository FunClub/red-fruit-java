package com.taomei.redfruit.business.trend.infrastructure.po;

import lombok.Data;

import java.util.List;

/**
 * 基础动态类
 */
@Data
public class Trend {

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

    /**
     * 是不是个人可见
     */
    private boolean isPrivate;

    /**
     * 点赞用户 id
     */
    private List<String> thumbUserIds;
}
