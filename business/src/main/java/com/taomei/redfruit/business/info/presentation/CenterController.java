package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人中心控制器
 */
@RestController
@RequestMapping("/user/center/")
public class CenterController {

    @Autowired
    private InfoService infoService;

    /**
     * 获取个人中心信息
     * @return
     */
    @RequestMapping("{centerUserId}")
    @SetUserId
    public Object getCenterInfo(Long userId,@PathVariable("centerUserId") Long centerUserId){
        CenterInfo centerInfo = infoService.selectCenterInfo(userId);
        centerInfo.setMine(userId.equals(centerUserId));
        return centerInfo;
    }
}
