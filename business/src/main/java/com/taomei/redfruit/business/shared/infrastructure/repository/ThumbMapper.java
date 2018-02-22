package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.shared.infrastructure.po.Thumb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThumbMapper extends BaseMapper<Thumb>{

    /**
     * 通过目标 Id 查询点赞用户 Id数组;
     * @param targetId 目标 Id
     * @return 点赞用户 Id数组;
     */
    List<String> selectUserIdByTargetId(String targetId);
}
