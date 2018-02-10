package com.taomei.redfruit.business.info.application.constant;

/**
 * 体重范围枚举
 */
public enum  RangeOfWeight {
    /**
     * 空
     */
    NULL("-1"),

    /**
     * 80-90斤
     */
    W80_90("0"),

    /**
     * 90-100斤
     */
    W90_100("1"),

    /**
     * 100-110斤
     */
    W100_110("2"),

    /**
     * 110-120斤
     */
    W110_120("3"),

    /**
     * 120-130斤
     */

    W130_140("4"),

    /**
     * 140-150斤
     */
    W140_150("5"),

    /**
     * 150斤以上
     */
    W150_OVER("6");


    private String rangeOfWeight;

    RangeOfWeight(String rangeOfWeight) {
        this.rangeOfWeight = rangeOfWeight;
    }
}
