package com.taomei.redfruit.business.user.domain.model;

import lombok.Data;

/**
 * 用户聚合
 */
@Data
public class User {

    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 魅力值
     */
    private Integer charisma;

    /**
     * 用户基本信息值对象
     */
    private BaseInfo baseInfo;

    /**
     * 用户择偶标准值对象
     */
    private LivingHabit livingHabit;

    /**
     * 用户择偶标准值对象
     */
    private SpouseCriterion spouseCriterion;

    /**
     * 增加用户魅力值
     * @param charisma 待增加的魅力值
     */
    public void increaseCharisma(Integer charisma){
        this.charisma += charisma;
    }
}
