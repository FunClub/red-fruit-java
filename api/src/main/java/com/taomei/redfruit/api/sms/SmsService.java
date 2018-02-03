package com.taomei.redfruit.api.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.api.common.ApiService;
import com.taomei.redfruit.api.sms.data.SmsResponse;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SmsService extends ApiService{

    @Autowired
    public SmsService(SmsConfiguration configuration){
        super(configuration.getHost(),configuration.getPath(),configuration.getAppCode(),configuration.getMethod());
    }

    /**
     * 发送短信验证码
     * @param mobile 目标手机号
     * @param code 验证码
     * @return 短信发送结果
     */
    public SmsResponse sendVerificationCode(String mobile,String code) throws Exception {
        queries.put("code", code);
        queries.put("phone", mobile);
        queries.put("skin", "5");

        String body = doGet();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body,SmsResponse.class);
    }
}
