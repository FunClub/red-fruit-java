package com.taomei.redfruit.business.user.domain.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.user.domain.model.User;

/**
 * 用户仓储接口
 */
public interface UserRepository extends IService<User>{

    void createUser(User user);
    /**
     * 通过手机号查询用户Id
     * @param mobile 手机号
     * @return 用户id
     */
    Long selectIdByMobile(String mobile);

    /**
     * 通过昵称查询用户Id
     * @param nickname 昵称
     * @return 用户id
     */
    Long selectIdByNickname(String nickname);
}
