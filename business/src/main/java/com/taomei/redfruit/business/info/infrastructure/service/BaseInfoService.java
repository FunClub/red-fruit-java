package com.taomei.redfruit.business.info.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import com.taomei.redfruit.business.info.application.dto.UserDtoAssembler;
import com.taomei.redfruit.business.info.application.repository.HalfRepository;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务实现
 */
@Service
public class BaseInfoService implements InfoService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HalfRepository halfRepository;

    /**
     * 查询个人空间信息
     *
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    @Override
    public CenterInfo selectCenterInfo(Long userId) {

        //获取用户信息
        User user = userRepository.selectById(userId);

        //获取用户另一半信息
        Half half = halfRepository.selectByUserId(userId);

        //如果有另一半
        User halfUser = null;
        if(half!=null){
            halfUser = userRepository.selectByHalfUser(userId,half);
        }
        return UserDtoAssembler.assembleCenterInfo(user,halfUser,half);
    }
}
