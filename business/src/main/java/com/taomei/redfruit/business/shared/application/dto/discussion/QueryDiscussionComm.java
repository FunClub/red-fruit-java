package com.taomei.redfruit.business.shared.application.dto.discussion;

import lombok.Data;

/**
 * 查询评论命令
 */
@Data
public class QueryDiscussionComm {

    /**
     * 想查询评论的用户 Id
     */
    private String userId;

    /**
     * 动态 Id
     */
    private String trendId;

    /**
     * 排序规则
     */
    private String sortBy;
}
