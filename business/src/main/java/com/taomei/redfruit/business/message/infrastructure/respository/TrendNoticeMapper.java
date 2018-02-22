package com.taomei.redfruit.business.message.infrastructure.respository;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.taomei.redfruit.business.message.application.dto.TrendNoticeInfo;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TrendNoticeMapper extends BaseMapper<TrendNotice>{

    /**
     * 查询动态通知
     * @param page 分页数据
     * @param userId 用户 Id
     * @return 分页的动态通知
     */
    List<TrendNoticeInfo> selectTrendNotice(@Param("page") Pagination page, @Param("userId") String userId);
}
