package com.taomei.redfruit.business.info.application.dto;

import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;

/**
 * 用户dto组装器
 */
public class UserDtoAssembler {

    /**
     * 组装用户个人的全部信息
     * @param user 用户信息
     * @param halfUser 用户的另一半用户信息
     * @return 用户个人的全部信息
     */
    public static AllUserInfo assembleAllUserInfo(User user,User halfUser){
        AllUserInfo allUserInfo = new AllUserInfo();
        UserInfo userInfo = new UserInfo();
        //如果有另一半
        if(halfUser!=null){
            SimplenessUserInfo simplenessUserInfo = new SimplenessUserInfo();
            BeanUtils.copyProperties(halfUser,simplenessUserInfo);
            allUserInfo.setHalfUserInfo(simplenessUserInfo);
        }
        BeanUtils.copyProperties(user,userInfo);
        userInfo.setAge(TimeUtils.calculateAge(user.getBirthday()));
        userInfo.setChineseZodiac(TimeUtils.calculateChineseZodiac(user.getBirthday()));
        userInfo.setStart(TimeUtils.calculateStart(user.getBirthday()));
        allUserInfo.setUserInfo(userInfo);
        return allUserInfo;
    }
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
