package com.taomei.redfruit.business.info.application.dto;

import lombok.Data;

/**
 * 搜索出来的用户信息
 */
@Data
public class SearchedUserInfo{
    private String userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String profile;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 居住地父级区域
     */
    private String parentArea;
    /**
     * 教育程度
     */
    private String education;

    /**
     * 月收入
     */
    private String income;

    /**
     * 年龄范围
     */
    private String criterionAge;

    /**
     * 身高范围
     */
    private String criterionHeight;

    /**
     * 意向对方城市，值为-1则为任意城市
     */
    private String criterionParentArea;

    /**
     * 收入范围
     */
    private String criterionIncome;

    /**
     * 推荐理由
     */
    private String recommendedReason;

    /**
     * 推荐度
     */
    private Integer recommendedPercent;

}
