package com.taomei.redfruit.business.trend.application;

import com.taomei.redfruit.business.trend.infrastructure.po.Mood;

/**
 * 心情服务接口
 */
public interface MoodService extends TrendService{

    /**
     * 创建心情
     *
     * @param mood  心情
     * @return 创建结果
     */
    boolean create(Mood mood);
}
