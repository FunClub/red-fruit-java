package com.taomei.redfruit.business.shared.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 子级评论
 */
@Data
public class SubDiscussion {

    /**
     * 子评论 Id
     */
    @TableId
    private String subDiscussionId;

    /**
     * 父级评论 id
     */
    private String parentDiscussionId;
    /**
     * 被回复的用户 id,为空则评论的父级评论，而不是某个子级评论
     */
    private String discussedUserId;


    /**
     * 发表子评论的用户
     */
    private String userId;

    /**
     * 发表的内容
     */
    private String content;

    /**
     * 发表时间
     */
    private String date;


}
