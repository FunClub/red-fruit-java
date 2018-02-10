package com.taomei.redfruit.business.info.application;

import com.taomei.redfruit.business.info.application.dto.CenterInfo;

/**
 * 用户信息服务接口
 */
public interface InfoService {

    /**
     * 查询个人空间信息
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    CenterInfo selectCenterInfo(Long userId);
}
