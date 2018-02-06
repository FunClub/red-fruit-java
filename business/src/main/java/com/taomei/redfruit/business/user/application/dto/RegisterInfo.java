package com.taomei.redfruit.business.user.application.dto;

import lombok.Data;

/**
 * 注册信息dto
 */
@Data
public class RegisterInfo {
    private String mobile;
    private String password;
    private String nickname;
    private String gender;
    private String birthday;
    private String parentArea;
    private String subArea;
    private String height;
    private String education;
    private String income;
    private String profile;
    private String banner;
}
