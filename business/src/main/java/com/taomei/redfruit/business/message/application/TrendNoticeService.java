package com.taomei.redfruit.business.message.application;

import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;

/**
 * 动态通知服务接口
 */
public interface TrendNoticeService {

    /**
     * 查询动态通知
     * @param pageComm 分页查询条件
     * @return 分页的动态通知
     */
    PagedInfo selectTrendNotice(PageComm<TrendNoticeInfo,String> pageComm);
    /**
     * 创建一个动态通知
     * @param notice 动态通知
     * @return 创建结果
     */
    boolean create(TrendNotice notice);
}
