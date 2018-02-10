package com.taomei.redfruit.business.info.application.dto;

import lombok.Data;

/**
 * 个人中心状态DTO
 */
@Data
public class CenterInfo {

    /**
     * 访问的个人空间是否是自己的
     */
    private boolean mine;

    /**
     * 访问的个人空间的用户是否拥有情侣
     */
    private boolean hasHalf;

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

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 另一半昵称
     */
    private String halfNickname;


}
