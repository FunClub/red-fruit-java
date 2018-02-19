package com.taomei.redfruit.business.shared.application.dto;

import lombok.Data;

/**
 * 用户简短信息
 */
@Data
public class UserShortInfo {

    /**
     * 用户id
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
}
