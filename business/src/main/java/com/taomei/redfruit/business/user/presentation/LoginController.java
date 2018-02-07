package com.taomei.redfruit.business.user.presentation;

import com.taomei.redfruit.business.user.application.LoginService;
import com.taomei.redfruit.business.user.infrastructure.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注册控制器
 */
@RestController
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * 登录
     * @param user 用户
     * @return 登录结果
     */
    @PostMapping("/")
    public Object login(@RequestBody User user){
        return service.login(user);
    }
}
