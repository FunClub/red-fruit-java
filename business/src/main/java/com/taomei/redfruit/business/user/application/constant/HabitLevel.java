package com.taomei.redfruit.business.user.application.constant;

/**
 * 习惯等级
 */
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
