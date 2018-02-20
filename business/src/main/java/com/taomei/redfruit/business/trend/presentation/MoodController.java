package com.taomei.redfruit.business.trend.presentation;

import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.QueryOtherComm;
import com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId;
import com.taomei.redfruit.business.trend.application.MoodService;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 通过个人中心查询心情
     * @return 分页心情数据
     */
    @PostMapping("center")
    @SetUserId
    public Object getByCenter(String userId,@RequestBody PageComm<MoodInfo,QueryOtherComm> pageComm){
        pageComm.getCondition().setViewUserId(userId);
        return moodService.getMoodByCenter(pageComm);
    }
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
