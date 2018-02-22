package com.taomei.redfruit.business.message.infrastructure.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.application.dto.MessageDtoAssembler;
import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.message.application.repository.TrendNoticeRepository;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动态通知服务实现
 */
@Service
public class BaseTrendNoticeService implements TrendNoticeService{

    @Autowired
    private TrendNoticeRepository trendNoticeRepository;

    @Autowired
    private UserRepository userRepository;
    /**
     * 查询动态通知
     *
     * @param pageComm 分页查询条件
     * @return 分页的动态通知
     */
    @Override
    public PagedInfo selectTrendNotice(PageComm<TrendNoticeInfo, String> pageComm) {
        Page<TrendNoticeInfo> page = pageComm.getPage();
        String userId = pageComm.getCondition();
        page = trendNoticeRepository.selectTrendNotice(page,userId);
        return MessageDtoAssembler.assembleTrendNoticeInfo(page,userRepository);
    }

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
