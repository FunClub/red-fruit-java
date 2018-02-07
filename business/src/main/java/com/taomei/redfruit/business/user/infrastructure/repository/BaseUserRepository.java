package com.taomei.redfruit.business.user.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.user.infrastructure.po.User;
import com.taomei.redfruit.business.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础用户仓储
 */
@Service
public class BaseUserRepository extends ServiceImpl<UserMapper,User> implements UserRepository{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(User user) {

    }

    /**
     * 通过手机号查询用户Id
     * @param mobile 手机号
     * @return 用户id
     */
    @Override
    public Long selectIdByMobile(String mobile) {
        return userMapper.selectIdByMobile(mobile);
    }

    /**
     * 通过昵称查询用户Id
     *
     * @param nickname 昵称
     * @return 用户id
     */
    @Override
    public Long selectIdByNickname(String nickname) {
        return userMapper.selectIdByNickname(nickname);
    }
}
