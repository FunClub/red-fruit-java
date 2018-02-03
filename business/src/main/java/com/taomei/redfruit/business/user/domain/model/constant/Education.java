package com.taomei.redfruit.business.user.domain.model.constant;

public enum  Education {

    /**
     * 空
     */
    NULL("-1"),

    /**
     * 大专及以下
     */
    COLLEGE_LOWER("0"),

    /**
     * 专科
     */
    COLLEGE("1"),

    /**
     * 学士
     */
    BACHELOR("2"),

    /**
     *硕士
     */
    MASTER("3"),

    /**
     * 博士
     */
    DOCTOR("4"),

    /**
     * 博士后
     */
    POST("5");

    private String education;

    Education(String education) {
        this.education = education;
    }
}
