package com.taomei.redfruit.api.sms.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 短信验证码响应数据
 *
 *    状态码                             消息
 *    OK		                        发送成功
 *    101		                        手机号码错误
 *    102		                        验证码内容过长
 *    105		                        模板编号错误
 *    isv.SMS_SIGNATURE_ILLEGAL		    短信签名不合法
 *    isv.INVALID_PARAMETERS		    参数异常
 *    isp.SYSTEM_ERROR		            系统错误
 *    isv.TEMPLATE_MISSING_PARAMETERS	模板缺少变量
 *    isv.BUSINESS_LIMIT_CONTROL		每分钟同一手机多次发送
 *    isv.BLACK_KEY_CONTROL_LIMIT		黑名单管控
 *    1009		                        短信总长度超过70
 */
@JsonIgnoreProperties({"RequestId","BizId"})
public class SmsResponse {

    /**
     * 状态码
     */
    @JsonProperty("Code")
    private String code;

    /**
     * 消息
     */
    @JsonProperty("Message")
    private String message;
}
