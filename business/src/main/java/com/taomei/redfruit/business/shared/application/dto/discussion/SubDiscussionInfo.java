package com.taomei.redfruit.business.shared.application.dto.discussion;

import lombok.Data;

/**
 * 子评论 dto
 */
@Data
public class SubDiscussionInfo {

    private String parentDiscussionId;
    /**
     *  评论人 id
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String profile;
    /**
     * 被回复的用户昵称
     */
    private String discussedNickname;

    /**
     * 被回复的用户 id,为空则评论的父级评论，而不是某个子级评论
     */
    private String discussedUserId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 分门别类时间
     */
    private String sortDate;

    /**
     * 简短时间
     */
    private String shortDate;

    /**
     * 时间
     */
    private String date;
}
