package com.taomei.redfruit.business.trend.application.dto;

import com.taomei.redfruit.business.trend.infrastructure.po.Photo;
import lombok.Data;

import java.util.List;

/**
 * 添加相片DTO
 */
@Data
public class AddPhotoComm {

    /**
     * 待添加的相片
     */
    private List<Photo> photos;

    /**
     * 相册 Id
     */
    private String albumId;

    /**
     * 用户 Id
     */
    private String userId;
}
