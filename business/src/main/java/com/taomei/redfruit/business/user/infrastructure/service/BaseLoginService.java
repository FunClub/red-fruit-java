package com.taomei.redfruit.business.user.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.taomei.redfruit.business.user.application.LoginService;
import com.taomei.redfruit.business.user.application.RegisterService;
import com.taomei.redfruit.business.user.infrastructure.po.User;
import com.taomei.redfruit.business.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录服务基本实现
 */
@Service
public class BaseLoginService implements LoginService {

    @Autowired
    private RegisterService registerService;
    /**
     * 登录
     *
     * @param user 用户
     * @return 登录结果
     */
    @Override
    public boolean login(User user) {
        return registerService.isUserExits(user);
    }
}
