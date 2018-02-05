package com.taomei.redfruit.business.user.infrastructure.application;

import com.taomei.redfruit.business.user.application.dto.RegisterInfo;
import com.taomei.redfruit.business.user.application.service.RegisterService;
import com.taomei.redfruit.business.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class BaseRegisterService implements RegisterService{
    @Autowired
    private UserRepository userRepository;
    /**
     * 用户注册
     *
     * @param registerInfo 注册时用户填写的信息
     * @return 注册成功与否
     */
    @Override
    public boolean register(RegisterInfo registerInfo) {
        return false;
    }

    /**
     * 验证用户手机号
     * 正确性、是否被注册等验证
     * @param mobile 手机号
     * @return true则手机可用
     */
    @Override
    public boolean verifyMobile(String mobile) {
        if(Pattern.matches("(^1[3|4|5|7|8]\\d{9}$)|(^09\\d{8}$)",mobile)){
            return userRepository.selectByMobile(mobile)!=null;
        }else{
            return false;
        }
    }
}
