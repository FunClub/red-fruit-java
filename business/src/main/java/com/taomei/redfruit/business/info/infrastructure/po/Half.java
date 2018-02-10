package com.taomei.redfruit.business.info.infrastructure.po;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 另一半
 */
@Data
public class Half{

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 另一半id
     */
    private Long halfUserId;

    /**
     * 墙纸
     */
    private String banner;

    /**
     * 点赞数
     */
    private Integer thumbsCount;


}
