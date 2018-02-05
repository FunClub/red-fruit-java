package com.taomei.redfruit.business.user.domain.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.user.domain.model.User;

/**
 * 用户仓储接口
 */
public interface UserRepository extends IService<User>{

    /**
     * 通过手机号查询用户
     * @param mobile 手机号
     * @return 用户
     */
    User selectByMobile(String mobile);
}
