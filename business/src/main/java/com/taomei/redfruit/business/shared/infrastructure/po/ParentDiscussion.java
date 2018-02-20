package com.taomei.redfruit.business.shared.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 父级评论
 */
@Data
public class ParentDiscussion {

    @TableId
    private String parentDiscussionId;

    /**
     * 动态 Id
     */
    private String trendId;

    /**
     * 发表评论的用户
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
     * 子评论数量
     */
    private Integer subDiscussionCount;
}
