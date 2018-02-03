package com.taomei.redfruit.business.user.domain.model;

import com.taomei.redfruit.business.user.domain.model.constant.HabitLevel;
import lombok.Data;

/**
 * 用户择偶标准值对象
 */
@Data
public class LivingHabit {

  /**
   * 是否吃辣
   */
  private HabitLevel eatHot;

  /**
   * 是否抽烟
   */
  private HabitLevel smoking;

  /**
   * 是否喝酒
   */
  private HabitLevel drinking;

  /**
   * 会做家务吗
   */
  private HabitLevel housework;

}
