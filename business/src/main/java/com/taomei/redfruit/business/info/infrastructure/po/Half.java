package com.taomei.redfruit.business.info.infrastructure.po;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 另一半
 */
@Data
public class Half{

    private String halfId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 另一半id
     */
    private String halfUserId;

    /**
     * 墙纸
     */
    private String banner;

    /**
     * 原始墙纸
     */
    private String originalBanner;
    /**
     * 点赞数
     */
    private Integer thumbsCount;


}
