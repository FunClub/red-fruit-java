package com.taomei.redfruit.business.info.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.taomei.redfruit.api.sms.SmsService;
import com.taomei.redfruit.api.sms.data.SmsResponse;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.info.application.RegisterService;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseRegisterService implements RegisterService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private SmsService smsService;
    /**
     * 用户注册
     * @param user 用户
     * @return 注册结果
     */
    @Override
    public Boolean register(User user) {
        user.setPassword(ValidatesUtil.generateEncryptPass(user.getPassword()));
        user.setBanner("");
        user.setProfile("assets/img/profile.png");
        user.setOriginalProfile("assets/img/profile.png");
        return repository.insert(user);
    }

    /**
     * 根据用户里的数据验证用户是否存在
     *
     * @param user 用户
     * @return 验证结果
     */
    @Override
    public Boolean isUserExits(User user) {
        return repository.selectCount(new EntityWrapper<>(user))==0;
    }

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @return 发送结果
     */
    @Override
    public Boolean sendMobileVerificationCode(String mobile,String verificationCode) throws Exception {
        SmsResponse response=smsService.sendVerificationCode(mobile, verificationCode);
        return "OK".equals(response.getCode());
    }
}
