package com.taomei.redfruit.business.info.application;

import com.taomei.redfruit.business.info.infrastructure.po.User;

/**
 * 注册应用服务接口
 */
public interface RegisterService {

    /**
     * 用户注册
     * @param user 用户聚合
     */
    Boolean register(User user);

    /**
     * 发送短信验证码
     * @param mobile 手机号
     * @param verificationCode 验证码
     * @return 发送结果
     */
    public Boolean sendMobileVerificationCode(String mobile,String verificationCode) throws Exception;

    /**
     * 根据用户里的数据验证用户是否存在
     * @param user 用户
     * @return 验证结果
     */
    public Boolean isUserExits(User user);
}
