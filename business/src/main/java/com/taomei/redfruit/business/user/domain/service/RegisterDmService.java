package com.taomei.redfruit.business.user.domain.service;

import com.taomei.redfruit.api.sms.SmsService;
import com.taomei.redfruit.api.sms.data.SmsResponse;
import com.taomei.redfruit.business.user.application.dto.RegisterInfo;
import com.taomei.redfruit.business.user.domain.model.User;
import com.taomei.redfruit.business.user.domain.repository.UserRepository;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * 注册领域服务
 */
@Service
public class RegisterDmService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SmsService smsService;

    /**
     * 验证用户手机号
     * 正确性、是否被注册等验证
     * @param mobile 手机号
     * @return true则手机可用
     */
    public boolean verifyMobile(String mobile) {
        if(Pattern.matches("(^1[3|4|5|7|8]\\d{9}$)|(^09\\d{8}$)",mobile)){
            return userRepository.selectIdByMobile(mobile)==null;
        }else{
            return false;
        }
    }

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @return 发送结果
     */
    public Boolean sendMobileVerificationCode(String mobile,String verificationCode) throws Exception {
        SmsResponse response = null;
        if(verifyMobile(mobile)){
            response=smsService.sendVerificationCode(mobile, verificationCode);
        }
        assert response != null;
        return "OK".equals(response.getCode());
    }



}
