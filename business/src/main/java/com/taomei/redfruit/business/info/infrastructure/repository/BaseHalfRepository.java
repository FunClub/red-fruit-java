package com.taomei.redfruit.business.info.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.info.application.repository.HalfRepository;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import org.springframework.stereotype.Service;

/**
 * 基本另一半信息仓储实现
 */
@Service
public class BaseHalfRepository extends ServiceImpl<HalfMapper,Half> implements HalfRepository{

    /**
     * 通过用户id查询另一半信息
     *
     * @param userId 用户id
     * @return 另一半信息
     */
    @Override
    public Half selectByUserId(Long userId) {
        Half half1 = new Half();
        half1.setUserId(userId);
        Half half= selectOne(new EntityWrapper<Half>(half1));

        if(half==null){
            Half half2 = new Half();
            half2.setHalfUserId(userId);
            half= selectOne(new EntityWrapper<Half>(half2));
        }
        return half;
    }
}
