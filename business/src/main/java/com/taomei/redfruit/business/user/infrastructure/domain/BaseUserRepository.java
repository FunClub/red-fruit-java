package com.taomei.redfruit.business.user.infrastructure.domain;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.user.domain.model.User;
import com.taomei.redfruit.business.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
