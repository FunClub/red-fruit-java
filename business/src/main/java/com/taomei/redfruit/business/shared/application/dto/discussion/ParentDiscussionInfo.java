package com.taomei.redfruit.business.shared.application.dto.discussion;

import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
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
     * 用户 Id
     */
    private String userId;
    /**
     * 点赞数量
     */
    private int thumbsUpCount;

    /**
     * 能否点赞
     */
    private boolean thumbsUpAble;



    /**
     * 用户简短信息
     */
    private UserShortInfo userShortInfo;
    /**
     * 评论内容
     */
    private String content;

    /**
     * 时间
     */
    private String date;

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
    List<SubDiscussionInfo> subDiscussionInfos;

    /**
     * 点赞用户 id列表
     */
    List<String> thumbsUserId;
}
