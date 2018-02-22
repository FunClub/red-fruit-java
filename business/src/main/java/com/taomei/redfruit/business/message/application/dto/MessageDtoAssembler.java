package com.taomei.redfruit.business.message.application.dto;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.discussion.DiscussionDtoAssembler;
import com.taomei.redfruit.business.shared.application.dto.discussion.ParentDiscussionInfo;
import com.taomei.redfruit.common.utils.TimeUtils;

import java.util.List;

/**
 * 消息DTO 组装器
 */
public class MessageDtoAssembler {

    /**
     * 组装动态通知
     * @param page 分页数据
     * @return 分页的动态通知
     */
    public static PagedInfo assembleTrendNoticeInfo(Page<TrendNoticeInfo> page, UserRepository userRepository){

        List<TrendNoticeInfo> trendNoticeInfos = page.getRecords();
        for (TrendNoticeInfo noticeInfo:trendNoticeInfos){
            noticeInfo.setShortDate(TimeUtils.generateShortDate(noticeInfo.getDate()));
            noticeInfo.setSortDate(TimeUtils.calculateSortDate(noticeInfo.getDate()));
            ParentDiscussionInfo parentDiscussionInfo = noticeInfo.getParentDiscussionInfo();
            if(parentDiscussionInfo!=null){
                DiscussionDtoAssembler.assembleParentDiscussionPagedInfo(parentDiscussionInfo,userRepository);
            }
        }
        PagedInfo pagedInfo = new PagedInfo();
        pagedInfo.setData(trendNoticeInfos);
        pagedInfo.setHasNext(page.hasNext());
        pagedInfo.setTotals(page.getTotal());
        return pagedInfo;
    }
}
