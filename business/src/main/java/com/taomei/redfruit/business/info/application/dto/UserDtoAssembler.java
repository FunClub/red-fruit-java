package com.taomei.redfruit.business.info.application.dto;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.constant.Gender;
import com.taomei.redfruit.business.info.application.constant.HabitLevel;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户dto组装器
 */
public class UserDtoAssembler {

    /**
     * 组装搜索出来的用户列表
     * @param page 分页数据
     * @return 用户列表
     */
    public static PagedInfo assembleSearchedUserInfo(Page<User> page){
        SearchedUserInfo userInfo = null;
        List<SearchedUserInfo> userInfos = new ArrayList<>();
        PagedInfo pagedInfo = new PagedInfo();

        List<User> users = page.getRecords();
        for (User user:users){
            userInfo = new SearchedUserInfo();
            BeanUtils.copyProperties(user,userInfo);
            userInfo.setAge(TimeUtils.calculateAge(user.getBirthday()));
            userInfo.setRecommendedReason(calculateRecommendedReason(user));
            userInfo.setRecommendedPercent(calculateRecommendedPercent(user));
            userInfos.add(userInfo);
        }
        pagedInfo.setData(userInfos);
        pagedInfo.setTotals(page.getTotal());
        pagedInfo.setHasNext(page.hasNext());
        return  pagedInfo;
    }

    /**
     * 计算推荐度
     * @param user 用户
     * @return 推荐度
     */
    private static Integer calculateRecommendedPercent(User user){
        int smoking = Integer.valueOf(user.getSmoking());
        int drink = Integer.valueOf(user.getDrinking());
        int housework = Integer.valueOf(user.getHousework());

        int percent =100;
        if(smoking!=0){
            percent = percent-smoking*11;
        }
        if (drink!=0){
            percent = percent-drink*11;
        }
        if(housework!=0){
            percent = percent+housework*11;
        }
        return percent;
    }
    /**
     * 计算推荐理由
     * @param user 用户
     * @return推荐理由
     */
    private static String calculateRecommendedReason(User user){
        String gender = user.getGender().equals(Gender.FEMALE.getGender())?"她":"他";
        if(HabitLevel.NO.getHabitLevel().equals(user.getSmoking())){
            return gender+"不抽烟，生活习惯较好，认识一下吧";
        }else if (HabitLevel.NO.getHabitLevel().equals(user.getDrinking())){
            return gender+"不喝酒，她可能就是你要找的人，聊聊吧";
        }else if(HabitLevel.much.getHabitLevel().equals(user.getDrinking())){
            return gender+"会做饭，你是个吃货吗？聊几句呗，不要错过缘分";
        }else {
            return "根据你的择偶要求，"+gender+"可能就是你要找的人，认识一下吧";
        }
    }
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
