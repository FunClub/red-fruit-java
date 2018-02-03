package com.taomei.redfruit.business.user.domain.model.constant;

/**
 * 身高范围枚举
 */
public enum RangeOfHeight {

    /**
     * 空
     */
    NULL("-1"),

    /**
     * 身高小于150cm
     */
    H150_LOWER("0"),

    /**
     * 150-154cm
     */
    H150_154("1"),

    /**
     * 155-159cm
     */
    H155_159("2"),

    /**
     * 160-164cm
     */
    H160_164("3"),

    /**
     * 165-169cm
     */
    H165_169("4"),

    /**
     * 170-174cm
     */
    H170_174("5"),

    /**
     * 175-179cm
     */
    H175_179("6"),

    /**
     *180-184cm
     */
    H180_184("7"),

    /**
     * 185-190cm
     */
    H185_190("8"),

    /**
     * 190cm以上
     */
    H190_OVER("9"),
    ;
    private String rangeOfHeight;

    RangeOfHeight(String rangeOfHeight) {
        this.rangeOfHeight = rangeOfHeight;
    }
}
