package com.taomei.redfruit.business.trend.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 相册
 */
@Data
public class Album extends Trend{

    /**
     * 相册 Id
     */
    @TableId
    private String albumId;

    /**
     * 相册名称
     */
    private String albumName;

    /**
     * 封面图片
     */
    private String coverImg;

    /**
     * 相片计数
     */
    private Integer photoCount;

}
