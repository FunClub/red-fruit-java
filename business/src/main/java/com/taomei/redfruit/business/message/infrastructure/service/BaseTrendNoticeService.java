package com.taomei.redfruit.business.message.infrastructure.service;

import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import org.springframework.stereotype.Service;


@Service
public class BaseTrendNoticeService implements TrendNoticeService{
    /**
     * 创建一个动态通知
     *
     * @param notice
     * @return
     */
    @Override
    public boolean create(TrendNotice notice) {
        return false;
    }
}
