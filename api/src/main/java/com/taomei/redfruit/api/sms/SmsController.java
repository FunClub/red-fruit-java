package com.taomei.redfruit.api.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
    @Autowired
    private SmsService service;
    @GetMapping("/{mobile}")
    public Object sendVerificationCode(@PathVariable("mobile") String mobile) throws Exception {
        return service.sendVerificationCode(mobile,"882487");
    }
}
