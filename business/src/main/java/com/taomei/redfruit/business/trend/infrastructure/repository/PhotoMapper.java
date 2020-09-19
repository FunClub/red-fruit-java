package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.trend.infrastructure.po.Photo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 相片映射器
 */
@Mapper
public interface PhotoMapper extends BaseMapper<Photo>{
}
