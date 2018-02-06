package com.taomei.redfruit.business.user.presentation;

import com.taomei.redfruit.business.user.application.service.RegisterAppService;
import com.taomei.redfruit.business.user.application.dto.RegisterInfo;
import com.taomei.redfruit.business.user.domain.model.User;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    @Qualifier("baseRegisterAppService")
    private RegisterAppService registerAppService;


    @PostMapping("/")
    public Object register(@RequestBody User user){
        registerAppService.register(user);
        return true;
    }
    /**
     * 手机号验证
     * @return 验证结果
     */
    @GetMapping("verifyMobile/{mobile}")
    public Object verifyMobile(@PathVariable("mobile") String mobile){
        return registerAppService.verifyMobile(mobile);
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
        Boolean result=registerAppService.sendMobileVerificationCode(mobile,verificationCode);
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
     * 验证昵称
     * @param nickname 昵称
     * @return 验证结果
     * @throws Exception
     */
    @GetMapping("verifyNickname/{nickname}")
    public Object verifyNickname(@PathVariable("nickname") String nickname) throws Exception {
        return registerAppService.verifyNickname(nickname);
    }
}
