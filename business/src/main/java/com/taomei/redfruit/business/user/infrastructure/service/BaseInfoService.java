package com.taomei.redfruit.business.user.infrastructure.service;

import com.taomei.redfruit.business.user.application.InfoService;
import com.taomei.redfruit.business.user.application.dto.CenterInfo;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务实现
 */
@Service
public class BaseInfoService implements InfoService{
    /**
     * 查询个人空间信息
     *
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    @Override
    public CenterInfo selectCenterInfo(Long userId) {
        return null;
    }
}
