package com.taomei.redfruit.business.trend.application.dto;

import com.taomei.redfruit.business.trend.infrastructure.po.Photo;
import lombok.Data;

@Data
public class PhotoInfo extends Photo{
    private String nickname;
    private String profile;
    private Long thumbsUpCount;
    private Long discussionCount;
    private Boolean thumbsUpAble;
}
