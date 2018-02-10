package com.taomei.redfruit.business.info.application.constant;

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
     * 5000到10000
     */
    I5000_10000("2"),

    /**
     * 10000到20000
     */
    I10000_20000("3"),

    /**
     * 20000到50000
     */
    I20000_50000("4"),

    /**
     * 50000以上
     */
    I50000_OVER("5");
    private String income;

    RangOfIncome(String income) {
        this.income = income;
    }
}
