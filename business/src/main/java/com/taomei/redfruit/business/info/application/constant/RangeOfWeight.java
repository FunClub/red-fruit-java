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
     * 80斤以下
     */
    W80_LOWER("0"),

    /**
     * 80-90斤
     */
    W80_90("1"),

    /**
     * 90-100斤
     */
    W90_100("2"),

    /**
     * 100-110斤
     */
    W100_110("3"),

    /**
     * 110-120斤
     */
    W110_120("4"),

    /**
     * 120-130斤
     */

    W130_140("5"),

    /**
     * 140-150斤
     */
    W140_150("6"),

    /**
     * 150斤以上
     */
    W150_OVER("7");


    private String rangeOfWeight;

    RangeOfWeight(String rangeOfWeight) {
        this.rangeOfWeight = rangeOfWeight;
    }
}
