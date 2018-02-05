package com.taomei.redfruit.business.user.infrastructure.domain;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.user.domain.model.User;
import com.taomei.redfruit.business.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseUserRepository extends ServiceImpl<UserMapper,User> implements UserRepository{

    /**
     * 通过手机号查询用户
     * @param mobile 手机号
     * @return 用户
     */
    @Override
    public User selectByMobile(String mobile) {
        Map<String,Object> map = new HashMap<>();
        map.put("mobile",mobile);
        List<User> users = selectByMap(map);
        return users.size()>0?users.get(0):null;
    }
}
