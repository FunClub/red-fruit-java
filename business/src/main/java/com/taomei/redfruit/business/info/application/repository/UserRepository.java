package com.taomei.redfruit.business.info.application.repository;

import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;

/**
 * 用户仓储接口
 */
public interface UserRepository extends IService<User>{

    /**
     * 通过另一半信息查询用户的另一半
     * @param userId 用户id
     * @param half 另一半信息
     * @return 用户
     */
    User selectByHalfUser(Long userId, Half half);
}
