package com.taomei.redfruit.business.message.infrastructure.respository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.message.application.repository.TrendNoticeRepository;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通知动态仓储实现
 */
@Service
public class BaseTrendNoticeRepository extends ServiceImpl<TrendNoticeMapper,TrendNotice> implements TrendNoticeRepository {

    @Autowired
    private TrendNoticeMapper mapper;

    /**
     * 查询动态通知
     *
     * @param page   分页数据
     * @param userId 用户 Id
     * @return 分页的动态通知
     */
    @Override
    public Page<TrendNoticeInfo> selectTrendNotice(Page<TrendNoticeInfo> page, String userId) {
        return page.setRecords(mapper.selectTrendNotice(page,userId));
    }
}
