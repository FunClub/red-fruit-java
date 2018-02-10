package com.taomei.redfruit.business.info.application.repository;

import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.info.infrastructure.po.Half;

/**
 * 另一半信息仓储
 */
public interface HalfRepository extends IService<Half>{

    /**
     * 通过用户id查询另一半信息
     * @param userId 用户id
     * @return 另一半信息
     */
    Half selectByUserId(Long userId);
}
