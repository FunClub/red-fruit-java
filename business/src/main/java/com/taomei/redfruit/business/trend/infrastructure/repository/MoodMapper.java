package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MoodMapper extends BaseMapper<Mood>{
    /**
     * 通过用户 id 查询心情
     * @param userIds 用户 Id 集合
     * @return 心情集合
     */
    List<MoodInfo> selectByUserIds(Pagination page, List<String> userIds);
}
