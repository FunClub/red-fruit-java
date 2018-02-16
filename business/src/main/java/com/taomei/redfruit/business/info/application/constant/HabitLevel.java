package com.taomei.redfruit.business.info.application.constant;

import lombok.Getter;

/**
 * 习惯等级
 */
@Getter
public enum HabitLevel {
    NO("0"),
    FEW("1"),
    much("2")
    ;
    private String habitLevel;

    HabitLevel(String habitLevel) {
        this.habitLevel = habitLevel;
    }
}
