package com.taomei.redfruit.business.trend.presentation;

import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import com.taomei.redfruit.business.trend.application.MoodService;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 心情控制器
 */
@RestController
@RequestMapping("/trend/mood/")
public class MoodController {
    /**
     * 心情服务
     */
    @Autowired
    private MoodService moodService;

    /**
     * 创建心情
     * @param mood  心情
     * @return 创建结果
     */
    @PostMapping("")
    @SetUserId
    public Object create(String userId, @RequestBody Mood mood){
        mood.setUserId(userId);
        return moodService.create(mood);
    }
}
