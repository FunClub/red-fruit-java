package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.trend.application.repository.PhotoRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Photo;
import org.springframework.stereotype.Service;

/**
 * 相片仓储实现类
 */
@Service
public class BasePhotoRepository extends ServiceImpl<PhotoMapper,Photo> implements PhotoRepository{
}
