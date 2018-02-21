package com.taomei.redfruit.business.message.infrastructure.respository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.message.infrastructure.po.TrendNotice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrendNoticeMapper extends BaseMapper<TrendNotice>{
}
