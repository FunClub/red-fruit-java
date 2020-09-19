package com.taomei.redfruit.business.trend.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

/**
 * 相片实体类
 */
@Data
public class Photo {

    /**
     * 相片 Id
     */
    @TableId
    private String photoId;

    /**
     * 相册 Id
     */
    private String albumId;

    /**
     * 用户 Id
     */
    private String userId;

    /**
     * 路径
     */
    private String path;

    /**
     * 相片名
     */
    private String name;

    /**
     * 水印字符串
     */
    private String waterMark;

    /**
     * 图片特效
     */
    private Integer bright;
    private Integer contrast;
    private Integer sharpen;
    private Integer blurR;
    private Integer blurS;
    private Integer zoomSize;
    private Integer fontSize;
    private Integer quality;

    /**
     * 上传时间
     */
    private String uploadDate;

    /**
     * 相片解释
     */
    private String description;
}
