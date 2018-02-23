package com.taomei.redfruit.business.shared.application.dto.discussion;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.dto.SimplenessUserInfo;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.business.shared.infrastructure.po.SubDiscussion;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 评论装配器
 */
public class DiscussionDtoAssembler {

    /**
     * 组装父级评论信息
     * @param page 分页数据
     * @param comm 查询命令
     * @param userRepository 用户仓储
     * @return
     */
    public static PagedInfo assembleParentDiscussionPagedInfo(Page<ParentDiscussionInfo> page,QueryDiscussionComm comm,
                                                              UserRepository userRepository){
        List<ParentDiscussionInfo> parentDiscussionInfos = page.getRecords();
        for (ParentDiscussionInfo parentDiscussionInfo:parentDiscussionInfos){
            assembleParentDiscussionPagedInfo(parentDiscussionInfo,userRepository);
        }
        PagedInfo pagedInfo = new PagedInfo();
        pagedInfo.setTotals(page.getTotal());
        pagedInfo.setHasNext(page.hasNext());
        pagedInfo.setData(page.getRecords());
        return pagedInfo;
    }
    public  static void assembleParentDiscussionPagedInfo(ParentDiscussionInfo parentDiscussionInfo,UserRepository userRepository){
        parentDiscussionInfo.setShortDate(TimeUtils.generateShortDate(parentDiscussionInfo.getDate()));
        parentDiscussionInfo.setSortDate(TimeUtils.calculateSortDate(parentDiscussionInfo.getDate()));

        //查询评论人相关信息
        UserShortInfo userShortInfo = userRepository.selectUserShortInfo(parentDiscussionInfo.getUserId());
        userShortInfo.setAge(TimeUtils.calculateAge(userShortInfo.getBirthday()));
        parentDiscussionInfo.setUserShortInfo(userShortInfo);

        //组装子级评论
        List<SubDiscussionInfo> subDiscussions = parentDiscussionInfo.getSubDiscussionInfos();
        if(subDiscussions!=null&&subDiscussions.size()>0){
            for (SubDiscussionInfo subDiscussionInfo:subDiscussions){
                subDiscussionInfo.setShortDate(TimeUtils.generateShortDate(subDiscussionInfo.getDate()));
                subDiscussionInfo.setSortDate(TimeUtils.calculateSortDate(subDiscussionInfo.getDate()));
                //查询评论人相关信息
                userShortInfo = userRepository.selectUserShortInfo(subDiscussionInfo.getUserId());
                subDiscussionInfo.setNickname(userShortInfo.getNickname());
                subDiscussionInfo.setProfile(userShortInfo.getProfile());
                //查询被评论人昵称
                userShortInfo = userRepository.selectUserShortInfo(subDiscussionInfo.getDiscussedUserId());
                if(userShortInfo!=null){
                    subDiscussionInfo.setDiscussedNickname(userShortInfo.getNickname());
                }
            }
        }
    }
    /**
     *  创建父评论时组装父级评论
     * @param parentDiscussion 父级评论

     * @param userRepository 用户仓储
     * @return 父级评论
     */
    public static ParentDiscussionInfo assembleParentDiscussionInfoForCreate(ParentDiscussion parentDiscussion, UserRepository userRepository){

        //组装父级评论
        ParentDiscussionInfo parentDiscussionInfo = new ParentDiscussionInfo();
        BeanUtils.copyProperties(parentDiscussion,parentDiscussionInfo);
        parentDiscussionInfo.setShortDate(TimeUtils.generateShortDate(parentDiscussion.getDate()));
        parentDiscussionInfo.setSortDate(TimeUtils.calculateSortDate(parentDiscussion.getDate()));

        //查询评论人相关信息
        UserShortInfo userShortInfo = userRepository.selectUserShortInfo(parentDiscussion.getUserId());
        userShortInfo.setAge(TimeUtils.calculateAge(userShortInfo.getBirthday()));
        parentDiscussionInfo.setUserShortInfo(userShortInfo);

        return parentDiscussionInfo;
    }

    /**
     *  创建子评论时组装子级评论
     * @param subDiscussion 子级评论
     * @param userRepository 用户仓储
     * @return 子级评论
     */
    public static SubDiscussionInfo assembleSubDiscussionInfoForCreate(SubDiscussion subDiscussion, UserRepository userRepository){

        //组装子级评论
        SubDiscussionInfo subDiscussionInfo = new SubDiscussionInfo();
        BeanUtils.copyProperties(subDiscussion,subDiscussionInfo);
        subDiscussionInfo.setShortDate(TimeUtils.generateShortDate(subDiscussion.getDate()));
        subDiscussionInfo.setSortDate(TimeUtils.calculateSortDate(subDiscussion.getDate()));

        //查询评论人相关信息
        UserShortInfo userShortInfo = userRepository.selectUserShortInfo(subDiscussionInfo.getUserId());
        subDiscussionInfo.setNickname(userShortInfo.getNickname());
        subDiscussionInfo.setProfile(userShortInfo.getProfile());
        //查询被评论人昵称
        userShortInfo = userRepository.selectUserShortInfo(subDiscussionInfo.getDiscussedUserId());
        if(userShortInfo!=null){
            subDiscussionInfo.setDiscussedNickname(userShortInfo.getNickname());
        }
        return subDiscussionInfo;
    }
}
