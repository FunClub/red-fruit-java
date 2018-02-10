package com.taomei.redfruit.business.info.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.taomei.redfruit.business.info.application.LoginService;
import com.taomei.redfruit.business.info.application.RegisterService;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.repository.UserMapper;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录服务基本实现
 */
@Service
public class BaseLoginService implements LoginService {

    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param user 用户
     * @return 登录结果
     */
    @Override
    public User login(User user) {
        user.setPassword(ValidatesUtil.generateEncryptPass(user.getPassword()));
        user = user.selectOne(new EntityWrapper<User>(user));
        if(user!=null){
            user.setPassword(null);
        }
        return user;
    }
}
