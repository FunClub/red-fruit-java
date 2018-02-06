package com.taomei.redfruit.business.user.infrastructure.application;

import com.taomei.redfruit.business.user.application.dto.RegisterInfo;
import com.taomei.redfruit.business.user.application.service.RegisterAppService;
import com.taomei.redfruit.business.user.domain.model.User;
import com.taomei.redfruit.business.user.domain.repository.UserRepository;
import com.taomei.redfruit.business.user.domain.service.RegisterDmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BaseRegisterAppService implements RegisterAppService {
    @Autowired
    private RegisterDmService registerDmService;

    @Autowired
    @Qualifier("baseUserRepository")
    private UserRepository userRepository;

    /**
     * 用户注册
     *
     * @param user 用户聚合
     */
    @Override
    public void register(User user) {
        userRepository.insert(user);
    }

    /**
     * 验证用户手机号
     * 正确性、是否被注册等验证
     * @param mobile 手机号
     * @return true则手机可用
     */
    @Override
    public boolean verifyMobile(String mobile) {
       return registerDmService.verifyMobile(mobile);
    }

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @return 发送结果
     */
    @Override
    public Boolean sendMobileVerificationCode(String mobile,String verificationCode) throws Exception {
        return registerDmService.sendMobileVerificationCode(mobile,verificationCode);
    }

    /**
     * 验证昵称
     * 正确性、是否被注册等验证
     *
     * @param nickname 手机号
     * @return true则昵称可用
     */
    @Override
    public Boolean verifyNickname(String nickname) {
        return userRepository.selectIdByNickname(nickname)==null;
    }
}
