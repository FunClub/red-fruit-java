package com.taomei.redfruit.business.info.application.repository;

import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;

/**
 * 用户仓储接口
 */
public interface UserRepository extends IService<User>{

    /**
     * 查询用户简短信息
     * @param userId 用户 id
     * @return 用户简短信息
     */
    UserShortInfo selectUserShortInfo(String userId);
    /**
     * 通过另一半信息查询用户的另一半
     * @param userId 用户id
     * @param half 另一半信息
     * @return 用户
     */
    User selectByHalfUser(String userId, Half half);

    /**
     * 通过id查询用户，不包括密码
     * @param userId 用户Id
     * @return 用户
     */
    User selectByIdExcludePass(String userId);
}
