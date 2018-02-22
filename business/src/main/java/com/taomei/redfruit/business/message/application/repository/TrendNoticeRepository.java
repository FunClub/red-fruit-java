package com.taomei.redfruit.business.message.application.repository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;

/**
 * 通知动态仓储接口
 */
public interface TrendNoticeRepository extends IService<TrendNotice>{

    /**
     * 查询动态通知
     * @param page 分页数据
     * @param userId 用户 Id
     * @return
     */
    Page<TrendNoticeInfo> selectTrendNotice(Page<TrendNoticeInfo> page,String userId);
}
