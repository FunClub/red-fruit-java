package com.taomei.redfruit.business.shared.presentation;

import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 共享控制器
 */
@RestController
@RequestMapping("business/shared")
public class SharedController {

    /**
     * 获取验证码
     * @param request {@link javax.servlet.http.HttpServletRequest;}
     * @param response {@link javax.servlet.http.HttpServletResponse;}
     */
    @GetMapping("/verificationCode")
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response){
        ValidatesUtil.createVerificationCodeImg(request,response);
    }
}
