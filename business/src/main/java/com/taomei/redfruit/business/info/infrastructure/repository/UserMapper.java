package com.taomei.redfruit.business.info.infrastructure.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    /**
     * 查询用户简短信息
     * @param userId 用户 id
     * @return 用户简短信息
     */
    UserShortInfo selectUserShortInfo(String userId);


}
