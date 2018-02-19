package com.taomei.redfruit.business.trend.application;

import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.QueryOtherComm;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;

/**
 * 心情服务接口
 */
public interface MoodService extends TrendService{

    /**
     * 通过个人中心查询心情
     * @param pageComm 分页命令
     * @return 分页心情数据
     */
    PagedInfo getMoodByCenter(PageComm<MoodInfo,QueryOtherComm> pageComm);

    /**
     * 创建心情
     * @param mood  心情
     * @return 创建结果
     */
    boolean create(Mood mood);


}
