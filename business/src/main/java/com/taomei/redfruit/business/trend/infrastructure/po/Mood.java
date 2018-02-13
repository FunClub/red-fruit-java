package com.taomei.redfruit.business.trend.infrastructure.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 心情
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Mood extends Trend{
    private String content;
}
