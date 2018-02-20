package com.taomei.redfruit.business.shared.application.dto.discussion;

import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import lombok.Data;

import java.util.List;

/**
 * 父级评论 dto
 */
@Data
public class ParentDiscussionInfo {

    /**
     *  父级评论 Id
     */
    private String parentDiscussionId;

    /**
     * 点赞数量
     */
    private Integer thumbsUpCount;

    /**
     * 能否点赞
     */
    private boolean thumbsUpAble;

    /**
     *  评论人 id
     */
    private String userId;

    /**
     * 昵称
     */
    private String nickname;


    private String profileImg;

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
     * 子评论列表
     */
    List<SubDiscussion> subDiscussions;
}
