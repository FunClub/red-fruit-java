package com.taomei.redfruit.business.info.application.dto;

import lombok.Data;

/**
 * 用户的择偶信息
 */
@Data
public class UserCriterionInfo {

    /**
     * 对方性别
     */
    private String halfGender;
    /**
     * 年龄范围
     */
    private String criterionAge;

    /**
     * 身高范围
     */
    private String criterionHeight;

    /**
     * 体重范围
     */
    private String criterionWeight;

    /**
     * 意向对方城市，值为-1则为任意城市
     */
    private String criterionParentArea;

    /**
     * 教育程度
     */
    private String criterionEducation;

    /**
     * 意向对方职业，值为-1则为任意职业
     */
    private String criterionProfession;

    /**
     * 收入范围
     */
    private String criterionIncome;

    /**
     * 是否有房
     */
    private String criterionHouseAvailable;

}
