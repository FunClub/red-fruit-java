package com.taomei.redfruit.business.user.domain.model.constant;

public enum Gender {
    /**
     * 女
     */
    FEMALE("0"),
    /**
     * 男
     */
    MALE("1");


    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
