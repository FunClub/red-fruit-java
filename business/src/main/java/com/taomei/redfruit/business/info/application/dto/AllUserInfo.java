package com.taomei.redfruit.business.info.application.dto;

import com.taomei.redfruit.business.info.infrastructure.po.User;
import lombok.Data;

/**
 * 用户的所有信息
 */
@Data
public class AllUserInfo {

    /**
     * 用户的另一半用户信息
     */
    private SimplenessUserInfo halfUserInfo;

    /**
     * 用户自身信息
     */
    private UserInfo userInfo;
}
