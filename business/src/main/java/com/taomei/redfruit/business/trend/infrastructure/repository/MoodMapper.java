package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoodMapper extends BaseMapper<Mood>{
}
