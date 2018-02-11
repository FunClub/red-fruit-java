package com.taomei.redfruit.business.info.application.dto;

import lombok.Data;

/**
 * 用户简单信息Dto
 */
@Data
public class SimplenessUserInfo {
    private Long id;
    private String nickname;
    private String profile;
    private Integer age;
    private Integer height;
    private String income;
    private String parentArea;
    private String subArea;
    private String introduction;
}
