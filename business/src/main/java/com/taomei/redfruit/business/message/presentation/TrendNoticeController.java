package com.taomei.redfruit.business.message.presentation;

import com.taomei.redfruit.business.message.application.TrendNoticeService;
import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态通知控制器
 */
@RestController
@RequestMapping("/message/trend-notice/")
public class TrendNoticeController {

    @Autowired
    private TrendNoticeService service;
    /**
     * 查询动态通知
     * @param pageComm 分页查询条件
     * @return 分页的动态通知
     */
    @PostMapping("")
    @SetUserId
    public Object selectTrendNotice(String userId,@RequestBody PageComm<TrendNoticeInfo,String> pageComm){
        pageComm.setCondition(userId);
        return service.selectTrendNotice(pageComm);
    }
}
