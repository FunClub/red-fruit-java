package com.taomei.redfruit.business.shared.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 评论通知标记实体类
 */
@Data
public class DiscussionNoticeFlag {

    /**
     * 父级评论 Id
     */
    private String parentDiscussionId;
    /**
     * 动态通知 Id
     */
    private String trendNoticeId;

    /**
     * 通知拥有者Id
     */
    private String noticeUserId;


}
