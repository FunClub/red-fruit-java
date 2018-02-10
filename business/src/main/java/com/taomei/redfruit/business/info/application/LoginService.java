package com.taomei.redfruit.business.info.application;

import com.taomei.redfruit.business.info.infrastructure.po.User;

/**
 * 登录服务接口
 */
public interface LoginService {

    /**
     * 登录
     * @param user 用户登录信息
     * @return 用户
     */
    User login(User user);
}
