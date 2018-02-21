package com.taomei.redfruit.business.trend.application.dto;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.SubDiscussionInfo;
import com.taomei.redfruit.common.utils.TimeUtils;

import java.util.List;

/**
 * 动态 dto 组装器
 */
public class TrendDtoAssembler {

    /**
     * 组装心情信息
     * @param page 分页心情数据
     * @param viewUserId 查看用户 Id
     * @return 心情信息
     */
    public static PagedInfo assembleMoodInfo(Page<MoodInfo> page,String viewUserId){
        List<MoodInfo> moodInfos = page.getRecords();
        List<String> thumbUserIds = null;
        PagedInfo pagedInfo = new PagedInfo();
        for (MoodInfo moodInfo:moodInfos){
            thumbUserIds = moodInfo.getThumbUserIds();

            //能否点赞
            if(thumbUserIds!=null){
                moodInfo.setThumbAble(!thumbUserIds.contains(viewUserId));
            }else{
                moodInfo.setThumbAble(true);
            }

            //简短时间
            moodInfo.setShortDate(TimeUtils.generateShortDate(moodInfo.getDate()));
            //多就之前发布的
            moodInfo.setHowLongAgo(TimeUtils.calculateHowLongAgo(moodInfo.getDate()));
        }
        pagedInfo.setData(moodInfos);
        pagedInfo.setHasNext(page.hasNext());
        pagedInfo.setTotals(page.getTotal());
        return pagedInfo;
    }
}
