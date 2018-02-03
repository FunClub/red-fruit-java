package com.taomei.redfruit.business.user.domain.model;

import com.taomei.redfruit.business.user.domain.model.constant.Education;
import com.taomei.redfruit.business.user.domain.model.constant.RangOfIncome;
import com.taomei.redfruit.business.user.domain.model.constant.RangeOfAge;
import com.taomei.redfruit.business.user.domain.model.constant.RangeOfHeight;
import lombok.Data;

/**
 * 用户择偶标准值对象
 */
@Data
public class SpouseCriterion {

  /**
   * 年龄范围
   */
  private RangeOfAge age;

  /**
   * 身高范围
   */
  private RangeOfHeight height;

  /**
   * 体重范围
   */
  private String weight;

  /**
   * 意向对方城市，值为-1则为任意城市
   */
  private String parent_area;

  /**
   * 教育程度
   */
  private Education education;

  /**
   * 意向对方职业，值为-1则为任意职业
   */
  private String profession;

  /**
   * 收入范围
   */
  private RangOfIncome income;

  /**
   * 是否有房
   */
  private Boolean house_available;

}
