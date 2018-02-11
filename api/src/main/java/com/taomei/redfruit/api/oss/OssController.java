package com.taomei.redfruit.api.oss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/file")
public class OssController {
    @Autowired
    private OssService fileService;

    @GetMapping("/upload")
    public Object t1() throws Exception{
        return "123";
    }
}
