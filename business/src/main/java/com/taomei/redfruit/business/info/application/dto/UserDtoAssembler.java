package com.taomei.redfruit.business.info.application.dto;

import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import org.springframework.beans.BeanUtils;

/**
 * 用户dto组装器
 */
public class UserDtoAssembler {

    /**
     * 组装用户个人中心信息
     * @param half 另一半
     * @param user 用户
     * @param halfUser 另一半用户
     * @return 用户个人中心信息
     */
    public static CenterInfo assembleCenterInfo(User user,User halfUser,Half half){
        CenterInfo info = new CenterInfo();

        if(halfUser!=null){
            BeanUtils.copyProperties(half,info);
            info.setHalfNickname(halfUser.getNickname());
            info.setBanner(half.getBanner());
            info.setHasHalf(true);
        }
        BeanUtils.copyProperties(user,info);

        return info;
    }


}
