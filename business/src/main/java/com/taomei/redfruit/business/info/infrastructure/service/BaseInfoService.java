package com.taomei.redfruit.business.info.infrastructure.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.application.constant.Gender;
import com.taomei.redfruit.business.info.application.dto.AllUserInfo;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import com.taomei.redfruit.business.info.application.dto.UserCriterionInfo;
import com.taomei.redfruit.business.info.application.dto.UserDtoAssembler;
import com.taomei.redfruit.business.info.application.repository.HalfRepository;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.Half;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

/**
 * 用户信息服务实现
 */
@Service
public class BaseInfoService implements InfoService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HalfRepository halfRepository;

    /**
     * 根据条件分页查询用户
     *
     * @param pageComm 分页条件
     * @return 已分页的用户信息
     */
    @Override
    public PagedInfo selectUsersBySearch(PageComm<User,UserCriterionInfo> pageComm) {
        UserCriterionInfo condition = pageComm.getCondition();
        Page<User> page = pageComm.getPage();
        EntityWrapper<User> wrapper = new EntityWrapper<>();

        //设置条件
        if(!condition.getCriterionProfession().equals("-1")){
            wrapper.eq("profession",condition.getCriterionProfession());
        }
        if(!condition.getCriterionHouseAvailable().equals("-1")){
            wrapper.eq("house_available",condition.getCriterionHouseAvailable());
        }
        if(!condition.getCriterionParentArea().equals("-1-")){
            wrapper.eq("parent_area",condition.getCriterionParentArea());
        }
        if(!condition.getCriterionEducation().equals("-1")){
            wrapper.ge("education",condition.getCriterionEducation());
        }
        if(!condition.getCriterionIncome().equals("-1")){
            wrapper.eq("income",condition.getCriterionIncome());
        }
        wrapper.eq("gender",condition.getHalfGender());
        setSearchUserWrapper(wrapper,false,condition.getCriterionWeight(),"weight");
        setSearchUserWrapper(wrapper,true,condition.getCriterionAge(),"birthday");
        setSearchUserWrapper(wrapper,false,condition.getCriterionHeight(),"height");
        page = userRepository.selectPage(page,wrapper);
        return UserDtoAssembler.assembleSearchedUserInfo(page);
    }

    /**
     *  设置查询用户的条件构造器
     * @param wrapper 条件构造器
     * @param column 字段
     * @param conditionString 条件字符串
     * @param isAge 条件是否是年龄
     * @return EntityWrapper
     */
    private void setSearchUserWrapper(EntityWrapper<User> wrapper,boolean isAge,String conditionString,String column){
        if(!conditionString.equals("-1")){
            String sequenceArray[] = null;
            String first = null;
            String last = null;
            sequenceArray = conditionString.split("-");
            first = sequenceArray[0];
            last = sequenceArray[1];
            if(isAge){
                if(last.equals("LOWER")){
                    wrapper.lt(column,TimeUtils.calculateDateByAge(first));
                }else if (last.equals("OVER")){
                    wrapper.gt(column,TimeUtils.calculateDateByAge(first));
                }else{
                    wrapper.between(column,TimeUtils.calculateDateByAge(last),TimeUtils.calculateDateByAge(first));
                }
            }else{
                if(last.equals("LOWER")){
                    wrapper.lt(column,first);
                }else if (last.equals("OVER")){
                    wrapper.gt(column,first);
                }else{
                    wrapper.between(column,first,last);
                }
            }

        }
    }
    /**
     * 查询用户的择偶信息
     * @param userId 用户id
     * @return 择偶信息
     */
    @Override
    public UserCriterionInfo selectUserCriterionInfo(String userId) {
        User user = userRepository.selectById(userId);
        UserCriterionInfo info = new UserCriterionInfo();
        BeanUtils.copyProperties(user,info);
        if(user.getGender().equals(Gender.FEMALE.getGender())){
            info.setHalfGender(Gender.MALE.getGender());
        }else {
            info.setHalfGender(Gender.FEMALE.getGender());
        }
        return info;
    }

    /**
     * 验证昵称是否可被更新
     *
     * @param user
     * @return
     */
    @Override
    public Boolean nicknameCanUpdate(User user) {
        User user1 = new User();
        user1.setNickname(user.getNickname());
        EntityWrapper<User> wrapper = new EntityWrapper<>(user1);
        wrapper.ne("id",user.getId());
        wrapper.eq("nickname",user.getNickname());
        return userRepository.selectOne(wrapper)==null;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return 成功与否
     */
    @Override
    public Boolean updateUserInfo(User user) {
        return user.updateById();
    }

    /**
     * 获取用户的全部信息
     *
     * @param userId 用户id
     * @return 用户的全部信息
     */
    @Override
    public AllUserInfo selectAllUserInfo(String userId) {
        User user = userRepository.selectByIdExcludePass(userId);
        Half half = halfRepository.selectByUserId(userId);
        User halfUser=null;
        if(half!=null){
            halfUser = userRepository.selectByHalfUser(userId,half);
        }
        return UserDtoAssembler.assembleAllUserInfo(user,halfUser);
    }

    /**
     * 查询个人空间信息
     *
     * @param userId 待查询的用户id
     * @return 个人空间信息
     */
    @Override
    public CenterInfo selectCenterInfo(String userId) {

        //获取用户信息
        User user = userRepository.selectById(userId);

        //获取用户另一半信息
        Half half = halfRepository.selectByUserId(userId);

        //如果有另一半
        User halfUser = null;
        if(half!=null){
            halfUser = userRepository.selectByHalfUser(userId,half);
        }
        return UserDtoAssembler.assembleCenterInfo(user,halfUser,half);
    }
}
