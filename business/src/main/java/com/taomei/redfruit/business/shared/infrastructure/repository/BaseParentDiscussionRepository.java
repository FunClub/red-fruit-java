package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.QueryDiscussionComm;
import com.taomei.redfruit.business.shared.application.repository.ParentDiscussionRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 父级评论仓储实现
 */
@Service
public class BaseParentDiscussionRepository extends ServiceImpl<ParentDiscussionMapper,ParentDiscussion> implements
        ParentDiscussionRepository {

    @Autowired
    private ParentDiscussionMapper parentDiscussionMapper;
    /**
     * 分页查询父级评论
     *
     * @param page    分页数据
     * @param comm 动态 Id
     * @return 分页的父级评论信息
     */
    @Override
    public Page<ParentDiscussionInfo> selectByPage(Page<ParentDiscussionInfo> page, QueryDiscussionComm comm) {
        return page.setRecords(parentDiscussionMapper.selectByPage(page,comm));
    }
}
