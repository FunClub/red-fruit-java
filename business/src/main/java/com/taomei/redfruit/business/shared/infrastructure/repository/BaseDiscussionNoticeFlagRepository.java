package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.repository.DiscussionNoticeFlagRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.DiscussionNoticeFlag;
import org.springframework.stereotype.Service;

/**
 * 评论通知标记仓储实现类
 */
@Service
public class BaseDiscussionNoticeFlagRepository extends ServiceImpl<DiscussionNoticeFlagMapper,DiscussionNoticeFlag> implements DiscussionNoticeFlagRepository {
}
