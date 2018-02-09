package com.taomei.redfruit.business.user.application.dto;

import lombok.Data;

/**
 * 个人中心状态DTO
 */

public class CenterInfo {

    /**
     * 访问的个人空间是否是自己的
     */
    private boolean isMine;

    /**
     * 访问的个人空间的用户是否拥有情侣
     */
    private boolean isHasHalf;

    /**
     * 墙纸
     */
    private String banner;

    /**
     * 点赞数
     */
    private Integer thumbsCount;

    /**
     * 用户头像
     */
    private String profile;

    /**
     * 另一半头像
     */
    private String halfProfile;

}
