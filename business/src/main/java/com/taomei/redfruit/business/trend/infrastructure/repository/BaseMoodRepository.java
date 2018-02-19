package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.application.repository.MoodRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心情仓储
 */
@Service
public class BaseMoodRepository extends ServiceImpl<MoodMapper,Mood> implements MoodRepository{
    @Autowired
    private MoodMapper moodMapper;
    /**
     * 通过用户 id 查询心情
     *
     * @param userIds 用户 Id 集合
     * @return 心情集合
     */
    @Override
    public Page<MoodInfo> selectByUserIds(Page<MoodInfo> page, List<String> userIds) {

        return page.setRecords(moodMapper.selectByUserIds(page,userIds));
    }
}
