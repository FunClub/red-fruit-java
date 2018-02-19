package com.taomei.redfruit.business.shared.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.trend.infrastructure.po.Img;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgMapper extends BaseMapper<Img>{
    List<String> selectByOfId(String ofId);
}
