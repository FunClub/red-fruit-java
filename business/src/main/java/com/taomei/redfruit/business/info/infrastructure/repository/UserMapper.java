package com.taomei.redfruit.business.info.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    /**
     * 通过手机号查询用户id
     * @param mobile 手机号
     * @return 用户id
     */
    String selectIdByMobile(@Param("mobile") String mobile);

    /**
     * 通过昵称查询用户Id
     * @param nickname 昵称
     * @return 用户id
     */
    String selectIdByNickname(@Param("nickname") String nickname);
}
