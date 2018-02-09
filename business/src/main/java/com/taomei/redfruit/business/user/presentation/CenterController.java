package com.taomei.redfruit.business.user.presentation;

import com.taomei.redfruit.business.user.application.InfoService;
import com.taomei.redfruit.business.user.application.dto.CenterInfo;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@RequestMapping("")
    public CenterInfo getCenterInfo(){

    }*/
}
