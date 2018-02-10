package com.taomei.redfruit.business.info.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础用户仓储
 */
@Service
public class BaseUserRepository extends ServiceImpl<UserMapper,User> implements UserRepository{

    /**
     * 通过另一半信息查询用户的另一半
     *
     * @param userId 用户id
     * @param half   另一半信息
     * @return 用户
     */
    @Override
    public User selectByHalfUser(Long userId, Half half) {
        Long halfUserId = half.getHalfUserId();
        User user = null;
        if(halfUserId.equals(userId)){
            user = selectById(half.getUserId());
        }else{
            user = selectById(halfUserId);
        }
        return user;
    }
}
