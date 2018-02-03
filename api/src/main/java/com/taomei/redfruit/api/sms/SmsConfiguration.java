package com.taomei.redfruit.api.sms;

import com.taomei.redfruit.api.common.ApiConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 短信验证码配置
 */
@ConfigurationProperties("api.sms")
@Component
public class SmsConfiguration extends ApiConfiguration {

}
