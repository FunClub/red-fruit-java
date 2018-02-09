package com.taomei.redfruit.business.user.infrastructure.po;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 另一半
 */
@Data
public class Half extends Model<Half>{

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

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
