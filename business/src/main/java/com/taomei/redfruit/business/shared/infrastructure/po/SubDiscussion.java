package com.taomei.redfruit.business.shared.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 子级评论
 */
@Data
public class SubDiscussion {
    @TableId
    private String subDiscussionId;
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

    /**
     * 被评论的用户 id,为空则评论的父级评论，而不是某个子级评论
     */
    private String discussedUserId;
}
