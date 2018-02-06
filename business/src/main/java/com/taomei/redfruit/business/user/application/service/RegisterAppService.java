package com.taomei.redfruit.business.user.application.service;

import com.taomei.redfruit.business.user.application.dto.RegisterInfo;
import com.taomei.redfruit.business.user.domain.model.User;

/**
 * 注册应用服务接口
 */
public interface RegisterAppService {

    /**
     * 用户注册
     * @param user 用户聚合
     */
    void register(User user);

    /**
     * 验证用户手机号
     * 正确性、是否被注册等验证
     * @param mobile 手机号
     * @return true则手机可用
     */
    public boolean verifyMobile(String mobile);

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @param verificationCode 验证码
     * @return 发送结果
     */
    public Boolean sendMobileVerificationCode(String mobile,String verificationCode) throws Exception;

    /**
     * 验证昵称
     * 正确性、是否被注册等验证
     * @param nickname 手机号
     * @return true则昵称可用
     */
    public Boolean verifyNickname(String nickname);
}
