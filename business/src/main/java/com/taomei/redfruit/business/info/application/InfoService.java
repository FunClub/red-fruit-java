package com.taomei.redfruit.business.info.application;

import com.taomei.redfruit.business.info.application.dto.AllUserInfo;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import com.taomei.redfruit.business.info.application.dto.UserCriterionInfo;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;

/**
 * 用户信息服务接口
 */
public interface InfoService {

    /**
     * 查询用户另一半 id
     * @param userId 用户 id
     * @return 用户另一半 id
     */
    String getHalfUserId(String userId);

    /**
     * 根据条件分页查询用户
     * @param pageComm 分页条件
     * @return 已分页的用户信息
     */
    PagedInfo selectUsersBySearch(PageComm<User,UserCriterionInfo> pageComm);

    /**
     * 查询用户的择偶信息
     * @param userId 用户id
     * @return 择偶信息
     */
    UserCriterionInfo selectUserCriterionInfo(String userId);

    /**
     * 验证昵称是否可被更新
     * @param user 用户
     * @return 验证结果
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
    AllUserInfo selectAllUserInfo(String userId);

    /**
     * 查询个人空间信息
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    CenterInfo selectCenterInfo(String userId);
}
