package com.taomei.redfruit.business.user.domain.model.constant;

/**
 * 用户月收入枚举
 */
public enum RangOfIncome {

    /**
     * 空
     */
    NULL("-1"),

    /**
     * 3000以下
     */
    I30000_LOWER("0"),

    /**
     * 3000到5000
     */
    I3OOO_5000("1"),

    /**
     * 5000到8000
     */
    I5000_8000("2"),

    /**
     * 8000到15000
     */
    I8000_15000("3"),

    /**
     * 15000以上
     */
    I15000_OVER("4");

    private String income;

    RangOfIncome(String income) {
        this.income = income;
    }
}
