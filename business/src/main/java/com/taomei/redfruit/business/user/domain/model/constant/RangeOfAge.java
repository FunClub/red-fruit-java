package com.taomei.redfruit.business.user.domain.model.constant;

/**
 * 年龄范围
 */
public enum  RangeOfAge {

    /**
     * 空
     */
    NULL("-1"),

    /**
     * 20岁以下
     */
    A20_LOWER("0"),

    /**
     * 20-24岁
     */
    A20_24("1"),

    /**
     * 25-29岁
     */
    A25_29("2"),

    /**
     * 30-34岁
     */
    A30_34("3"),

    /**
     * 35-40岁
     */
    A35_40("4"),

    /**
     * 40岁以上
     */
    A40_OVER("5"),
    ;
    private String rangeOfAge;

    RangeOfAge(String rangeOfAge) {
        this.rangeOfAge = rangeOfAge;
    }
}
