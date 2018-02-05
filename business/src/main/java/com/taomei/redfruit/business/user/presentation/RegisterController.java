package com.taomei.redfruit.business.user.presentation;

import com.taomei.redfruit.business.user.application.service.RegisterService;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注册控制器
 */
@RestController
@RequestMapping("business/user/register")
public class RegisterController {

    /**
     * 基本注册服务
     */
    @Autowired
    @Qualifier("baseRegisterService")
    private RegisterService registerService;


    /**
     * 手机号验证
     * @return
     */
    @GetMapping("verifyMobile/{mobile}")
    public Object verifyMobile(@PathVariable("mobile") String mobile){
        return registerService.verifyMobile(mobile);
    }
}
