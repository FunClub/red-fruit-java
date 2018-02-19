package com.taomei.redfruit.business.shared.application.dto;

import lombok.Data;

/**
 * 查询其他用户数据的命令
 */
@Data
public class QueryOtherComm {

    /**
     * 数据所属用户 id
     */
    String  ofUserId;

    //查阅数据的用户 id
    String viewUserId;
}
