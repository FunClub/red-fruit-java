package com.taomei.redfruit.business.message.application;

import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;

/**
 * 动态通知服务接口
 */
public interface TrendNoticeService {

    /**
     * 创建一个动态通知
     * @param notice
     * @return
     */
    boolean create(TrendNotice notice);
}
