package com.taomei.redfruit.business.trend.application.dto;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.UserShortInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.SubDiscussionInfo;
import com.taomei.redfruit.business.shared.application.repository.ParentDiscussionRepository;
import com.taomei.redfruit.business.shared.infrastructure.po.ParentDiscussion;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 动态 dto 组装器
 */
public class TrendDtoAssembler {

    /**
     * 组装心情信息
     *
     * @param page       分页心情数据
     * @param viewUserId 查看用户 Id
     * @return 心情信息
     */
    public static PagedInfo assembleMoodInfo(Page<MoodInfo> page, String viewUserId,ParentDiscussionRepository parentDiscussionRepository) {
        List<MoodInfo> moodInfos = page.getRecords();
        List<String> thumbUserIds = null;
        PagedInfo pagedInfo = new PagedInfo();
        for (MoodInfo moodInfo : moodInfos) {
            thumbUserIds = moodInfo.getThumbUserIds();

            //能否点赞
            if (thumbUserIds != null&&thumbUserIds.size()>0) {
                moodInfo.setThumbAble(!thumbUserIds.contains(viewUserId));
                moodInfo.setThumbsUpCount(thumbUserIds.size());
            } else {
                moodInfo.setThumbAble(true);
                moodInfo.setThumbsUpCount(0);
            }

            //简短时间
            moodInfo.setShortDate(TimeUtils.generateShortDate(moodInfo.getDate()));
            //多就之前发布的
            moodInfo.setHowLongAgo(TimeUtils.calculateHowLongAgo(moodInfo.getDate()));
            //设置评论数量
            int discussionCount = parentDiscussionRepository.
                    selectCount(new EntityWrapper<ParentDiscussion>().eq("trend_id",moodInfo.getMoodId()));
            moodInfo.setDiscussionCount(discussionCount);
        }
        pagedInfo.setData(moodInfos);
        pagedInfo.setHasNext(page.hasNext());
        pagedInfo.setTotals(page.getTotal());
        return pagedInfo;
    }

    /**
     * 创建心情时组装心情信息
     *
     * @param mood       心情数据
     * @param userRepository 用户仓储
     * @return 心情信息
     */
    public static MoodInfo assembleMoodInfoForCreate(Mood mood, UserRepository userRepository) {
        MoodInfo moodInfo = new MoodInfo();
        BeanUtils.copyProperties(mood, moodInfo);
        moodInfo.setThumbAble(true);
        UserShortInfo shortInfo = userRepository.selectUserShortInfo(mood.getUserId());
        moodInfo.setShortInfo(shortInfo);
        //简短时间
        moodInfo.setShortDate(TimeUtils.generateShortDate(moodInfo.getDate()));
        //多就之前发布的
        moodInfo.setHowLongAgo(TimeUtils.calculateHowLongAgo(moodInfo.getDate()));

        return moodInfo;
    }

}
