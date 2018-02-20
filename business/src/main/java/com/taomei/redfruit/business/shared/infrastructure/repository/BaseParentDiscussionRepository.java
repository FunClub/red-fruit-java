package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.repository.ParentDiscussionRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import org.springframework.stereotype.Service;

/**
 * 父级评论仓储实现
 */
@Service
public class BaseParentDiscussionRepository extends ServiceImpl<ParentDiscussionMapper,ParentDiscussion> implements
        ParentDiscussionRepository {

}
