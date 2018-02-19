package com.taomei.redfruit.business.trend.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 图片实体
 */
@Data

public class Img {

    /**
     * 图片 id
     */
    @TableId
    private String imgId;

    /**
     * 所属 id
     */
    private String ofId;

    /**
     * 路径
     */
    private String path;

    public Img() {
    }

    public Img(String ofId, String path) {
        this.ofId = ofId;
        this.path = path;
    }
}
