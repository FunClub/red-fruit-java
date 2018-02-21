package com.taomei.redfruit.business.shared.application.repository;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.QueryDiscussionComm;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;

/**
 * 父级评论仓储
 */
public interface ParentDiscussionRepository extends IService<ParentDiscussion>{

    /**
     * 分页查询父级评论
     * @param page 分页数据
     * @param comm 查询条件
     * @return 分页的父级评论信息
     */
    Page<ParentDiscussionInfo> selectByPage(Page<ParentDiscussionInfo> page, QueryDiscussionComm comm);
}
