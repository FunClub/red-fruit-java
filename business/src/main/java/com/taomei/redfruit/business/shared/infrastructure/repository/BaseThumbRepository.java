package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.repository.ThumbRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.Thumb;
import org.springframework.stereotype.Service;

/**
 * 点赞仓储实现
 */
@Service
public class BaseThumbRepository extends ServiceImpl<ThumbMapper,Thumb> implements ThumbRepository {
}
