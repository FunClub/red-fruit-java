package com.taomei.redfruit.business.trend.application.repository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;

import java.util.List;

/**
 * 心情仓储
 */
public interface MoodRepository extends IService<Mood>{
    /**
     * 通过用户 id 查询心情
     * @param userIds 用户 Id 集合
     * @return 心情集合
     */
    Page<MoodInfo> selectByUserIds(Page<MoodInfo> page, List<String> userIds);
}
