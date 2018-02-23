package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.QueryDiscussionComm;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParentDiscussionMapper extends BaseMapper<ParentDiscussion>{

    /**
     * 查询父级评论
     *
     * @param id   父级评论id
     * @return 父级评论信息
     */
    ParentDiscussionInfo selectParentDiscussionInfoById(String id);

    /**
     * 查询评论数量通过 动态 Id
     * @param trendId 动态 Id
     * @return 评论数量
     */
    Integer selectCountByTrendId(String trendId);

    /**
     * 分页查询父级评论
     *
     * @param pagination   分页数据
     * @param comm 查询条件
     * @return 分页的父级评论信息
     */
    List<ParentDiscussionInfo> selectByPage(Pagination pagination, @Param("comm") QueryDiscussionComm comm);
}
