package com.taomei.redfruit.business.user.application.service;

import com.taomei.redfruit.business.user.application.dto.RegisterInfo;

/**
 * 注册服务接口
 */
public interface RegisterService {

    /**
     * 用户注册
     * @param registerInfo 注册时用户填写的信息
     * @return 注册成功与否
     */
    boolean register(RegisterInfo registerInfo);

}
