package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.business.info.application.LoginService;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
     * @return 用户
     */
    @PostMapping("/")
    public Object login(@RequestBody User user, HttpSession session){
        user = service.login(user);
        if(user!=null){
            session.setAttribute("user",user);
            return true;
        }else{
            return false;
        }

    }

    /**
     * 判断是否登录，获取登录状态
     * @param session
     * @return
     */
    @GetMapping("status")
    public Object getLoginStatus(HttpSession session){
        return session.getAttribute("user")!=null;
    }
}
