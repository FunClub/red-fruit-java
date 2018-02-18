package com.taomei.redfruit.business.trend.infrastructure.service;

import com.taomei.redfruit.business.trend.application.MoodService;
import com.taomei.redfruit.business.trend.application.TrendService;
import com.taomei.redfruit.business.trend.application.repository.MoodRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 心情服务实现类
 */
@Service
public class BaseMoodService implements MoodService{

    @Autowired
    private MoodRepository moodRepository;

    /**
     * 创建心情
     *
     * @param mood  心情
     * @return 创建结果
     */
    @Override
    public boolean create(Mood mood) {
        mood.setDate(TimeUtils.generateDateTimeString());
        List<String> imgs = mood.getImgs();
        StringBuilder sb = new StringBuilder("");
        for(String img:imgs){
            sb.append(img+"$");
        }
        mood.setImgStr(sb.toString());
        return moodRepository.insert(mood);
    }

    /**
     * 删除动态
     *
     * @param trendId 动态ID
     * @return 删除结果
     */

    public boolean delete(String trendId) {
        return false;
    }
}
