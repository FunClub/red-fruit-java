package com.taomei.redfruit.business.user.infrastructure.domain;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.taomei.redfruit.business.user.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
