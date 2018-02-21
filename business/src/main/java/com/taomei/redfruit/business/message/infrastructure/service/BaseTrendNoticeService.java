package com.taomei.redfruit.business.message.infrastructure.service;

import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.application.repository.TrendNoticeRepository;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动态通知服务实现
 */
@Service
public class BaseTrendNoticeService implements TrendNoticeService{

    @Autowired
    private TrendNoticeRepository trendNoticeRepository;
    /**
     * 创建一个动态通知
     *
     * @param notice
     * @return
     */
    @Override
    public boolean create(TrendNotice notice) {
        return trendNoticeRepository.insert(notice);
    }
}
