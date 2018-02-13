package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.business.info.application.RegisterService;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 注册控制器
 */
@RestController
@RequestMapping("/user/register/")
public class RegisterController {

    /**
     * 注册服务
     */
    @Autowired
    private RegisterService service;

    @PostMapping("")
    public Object register(@RequestBody User user){
        return service.register(user);
    }

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @return 发送结果
     * @throws Exception
     */
    @GetMapping("mobileVerificationCode/{mobile}")
    public Object sendMobileVerificationCode(@PathVariable("mobile") String mobile, HttpSession session) throws Exception {
        String verificationCode = ValidatesUtil.generateRandomNumber(6);
        Boolean result=service.sendMobileVerificationCode(mobile,verificationCode);
        session.setAttribute("mobileVerificationCode",verificationCode);
        return result;
    }

    /**
     * 手机短信验证码验证
     * @param code 手机短信验证码
     * @return 验证结果
     * @throws Exception
     */
    @PutMapping("mobileVerificationCode/{mobileCode}")
    public Object verifyMobileVerificationCode(@PathVariable("mobileCode") String code, HttpSession session) throws Exception {
        Object codeObj = session.getAttribute("mobileVerificationCode");
        if(codeObj!=null){
            String truthCode = codeObj.toString();
            return truthCode.equals(code);
        }
        return false;
    }


    /**
     * 根据用户里的数据验证用户是否存在
     * @param user 用户
     * @return 验证结果
     */
    @PostMapping("isUserExits")
    public Object isUserExits(@RequestBody User user){
        return service.isUserExits(user);
    }
    /**
     * 获取验证码
     * @param request {@link javax.servlet.http.HttpServletRequest;}
     * @param response {@link javax.servlet.http.HttpServletResponse;}
     */
    @GetMapping("/verificationCodeImg")
    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response){
        ValidatesUtil.createVerificationCodeImg(request,response);
    }

    @GetMapping("/verifyImgVerificationCode/{verificationCode}")
    public Object verify(@PathVariable("verificationCode") String verificationCode, HttpSession session){
        String truthCode = session.getAttribute("verificationCode").toString();
        return truthCode.equals(verificationCode.toUpperCase());
    }
}
