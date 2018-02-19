package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.repository.ImgRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Img;
import org.springframework.stereotype.Service;

/**
 * 图片仓储
 */
@Service
public class BaseImgRepository extends ServiceImpl<ImgMapper,Img> implements ImgRepository {
}
