package com.taomei.redfruit.business.user.application;

import com.taomei.redfruit.business.user.infrastructure.po.User;

/**
 * 登录服务接口
 */
public interface LoginService {

    /**
     * 登录
     * @param user 用户
     * @return 登录结果
     */
    boolean login(User user);
}
