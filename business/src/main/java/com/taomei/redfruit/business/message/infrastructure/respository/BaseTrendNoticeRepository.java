package com.taomei.redfruit.business.message.infrastructure.respository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.message.application.repository.TrendNoticeRepository;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import org.springframework.stereotype.Service;

/**
 * 通知动态仓储实现
 */
@Service
public class BaseTrendNoticeRepository extends ServiceImpl<TrendNoticeMapper,TrendNotice> implements TrendNoticeRepository {
}
