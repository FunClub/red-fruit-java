package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 相册映射器
 */
@Mapper
public interface AlbumMapper  extends BaseMapper<Album>{

    List<Album> findByHalf(@Param("userId") String userId, @Param("halfUserId")String halfUserId);
}
