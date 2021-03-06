package com.taomei.redfruit.business.info.application.dto;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class UserInfo extends UserCriterionInfo{
    private String userId;

    /**
     * 魅力值
     */
    private Integer charisma;


    /**
     * 昵称
     */
    private String nickname;

    /**
     * 个人简介
     */
    private String introduction;


    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 生肖
     */
    private String chineseZodiac;

    /**
     * 生肖
     */
    private String start;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 居住地父级区域
     */
    private String parentArea;

    /**
     * 居住地子级区域
     */
    private String subArea;

    /**
     * 教育程度
     */
    private String education;

    /**
     * 职业
     */
    private String profession;

    /**
     * 月收入
     */
    private String income;

    /**
     * 是否有房
     */
    private String houseAvailable;

    /**
     * 是否吃辣
     */
    private String eatHot;

    /**
     * 是否抽烟
     */
    private String smoking;

    /**
     * 是否喝酒
     */
    private String drinking;

    /**
     * 会做家务吗
     */
    private String housework;
    /**
     * 喜欢购物吗
     */
    private String shopping;
    /**
     * 喜欢电影吗
     */
    private String movie;
    /**
     * 喜欢动物吗
     */
    private String animal;
    /**
     * 喜欢游戏吗
     */
    private String game;

    /**
     * 增加用户魅力值
     * @param charisma 待增加的魅力值
     */
    public void increaseCharisma(Integer charisma){
        this.charisma += charisma;
    }
}
