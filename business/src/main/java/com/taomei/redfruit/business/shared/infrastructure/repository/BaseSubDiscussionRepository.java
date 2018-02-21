package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.repository.SubDiscussionRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import org.springframework.stereotype.Service;

/**
 * 子评论仓储实现
 */
@Service
public class BaseSubDiscussionRepository extends ServiceImpl<SubDiscussionMapper,SubDiscussion> implements SubDiscussionRepository {
}
