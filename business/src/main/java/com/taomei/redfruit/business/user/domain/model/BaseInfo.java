package com.taomei.redfruit.business.user.domain.model;

import com.taomei.redfruit.business.user.domain.model.constant.Education;
import com.taomei.redfruit.business.user.domain.model.constant.Gender;
import com.taomei.redfruit.business.user.domain.model.constant.RangOfIncome;
import lombok.Data;

import java.time.LocalDate;

/**
 * 用户基本信息值对象
 */
@Data
public class BaseInfo {

  /**
   * 昵称
   */
  private String nickname;

  /**
   * 性别
   */
  private Gender gender;

  /**
   * 生日
   */
  private LocalDate birthday;

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
  private Education education;

  /**
   * 职业
   */
  private String profession;

  /**
   * 月收入
   */
  private RangOfIncome rangOfIncome;

  /**
   * 是否有房
   */
  private Boolean house_available;


}
