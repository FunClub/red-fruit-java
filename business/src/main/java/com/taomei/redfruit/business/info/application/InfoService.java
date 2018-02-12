package com.taomei.redfruit.business.info.application;

import com.taomei.redfruit.business.info.application.dto.AllUserInfo;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import com.taomei.redfruit.business.info.infrastructure.po.User;

/**
 * 用户信息服务接口
 */
public interface InfoService {

    /**
     * 验证昵称是否可被更新
     * @param user
     * @return
     */
    Boolean nicknameCanUpdate(User user);
    /**
     * 更新用户信息
     * @param user 用户
     * @return 成功与否
     */
    Boolean updateUserInfo(User user);
    /**
     * 获取用户的全部信息
     * @param userId 用户id
     * @return 用户的全部信息
     */
    AllUserInfo selectAllUserInfo(Long userId);

    /**
     * 查询个人空间信息
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    CenterInfo selectCenterInfo(Long userId);
}
