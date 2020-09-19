package com.taomei.redfruit.business.trend.application.dto;

import lombok.Data;

/**
 * 上传的图片信息
 */
@Data
public class UploadPhotoInfo {
    private String path;
    private int width;
    private int height;
    private int fontSize;
    private String name;
    private int zoomSize;
}
