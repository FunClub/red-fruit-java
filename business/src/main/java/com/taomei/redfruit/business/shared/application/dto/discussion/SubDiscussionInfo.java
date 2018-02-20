package com.taomei.redfruit.business.shared.application.dto.discussion;

import lombok.Data;

/**
 * 子评论 dto
 */
@Data
public class SubDiscussionInfo {

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
}
