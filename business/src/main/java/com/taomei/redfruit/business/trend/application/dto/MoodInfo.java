package com.taomei.redfruit.business.trend.application.dto;

import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import lombok.Data;

import java.util.List;

/**
 * 心情 dto
 */
@Data
public class MoodInfo extends Mood{

    /**
     * 用户简短信息
     */
    private UserShortInfo shortInfo;

    /**
     * 短时间
     */
    private String shortDate;

    /**
     * 好久之前发送的
     */
    private String howLongAgo;

    /**
     * 能否点赞
     */
    private boolean thumbAble;

    /**
     * 点赞的用户 Id 列表
     */
    private List<String> thumbUserIds;

    /**
     * 点赞数量
     */
    private Integer thumbsUpCount;

    private Integer discussionCount;
}
