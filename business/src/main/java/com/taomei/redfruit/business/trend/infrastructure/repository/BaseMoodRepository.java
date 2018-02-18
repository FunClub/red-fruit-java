package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.trend.application.repository.MoodRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.springframework.stereotype.Service;

/**
 * 心情仓储
 */
@Service
public class BaseMoodRepository extends ServiceImpl<MoodMapper,Mood> implements MoodRepository{
}
