package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.shared.application.dto.discussion.SubDiscussionInfo;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubDiscussionMapper extends BaseMapper<SubDiscussion> {

    /**
     * 通过父级评论Id查询子评论
     * @param parentDiscussionId 父级评论 Id
     * @return 子评论集合
     */
    List<SubDiscussionInfo> selectByParentDiscussionId(String parentDiscussionId);
}
