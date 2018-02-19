package com.taomei.redfruit.business.info.infrastructure.po;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 用户
 */
@Data
public class User extends Model<User>{
    @TableId
    private String userId;

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
     * 昵称
     */
    private String nickname;

    /**
     * 个人简介
     */
    private String introduction;
    /**
     * 头像
     */
    private String profile;

    /**
     * 原始头像
     */
    private String originalProfile;

    /**
     * 墙纸
     */
    private String banner;

    /**
     * 原始墙纸
     */
    private String originalBanner;
    /**
     * 性别
     */
    private String gender;

    /**
     * 生日    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
     */
    private String birthday;

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

    /**
     * 增加用户魅力值
     * @param charisma 待增加的魅力值
     */
    public void increaseCharisma(Integer charisma){
        this.charisma += charisma;
    }

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
