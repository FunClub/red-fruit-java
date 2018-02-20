package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.api.oss.OssService;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId;
import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.application.dto.CenterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 个人中心控制器
 */
@RestController
@RequestMapping("/user/center/")
public class CenterController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private OssService ossService;

    @PostMapping("profile")
    @SetUserId
    public Object uploadProfile(
            String userId,
            @RequestParam("newImg") MultipartFile newImg,
            String originalImg,
            @RequestParam("type") String type) throws IOException {
        User user = new User();
        user.setUserId(userId);
        if(type.equals(OssService.PROFILE)){
            user.setProfile(ossService.upload(newImg,OssService.PROFILE));
            if(originalImg!=null){
                user.setOriginalProfile(originalImg);
            }
        }else{
            user.setBanner(ossService.upload(newImg,OssService.BANNER));
            if(originalImg!=null){
                user.setOriginalBanner(originalImg);
            }
        }

        return user.updateById();
    }

    /**
     * 获取个人中心信息
     * @return
     */
    @RequestMapping("{centerUserId}")
    @SetUserId
    public Object getCenterInfo(String userId,@PathVariable("centerUserId") String centerUserId){
        CenterInfo centerInfo = infoService.selectCenterInfo(centerUserId);
        centerInfo.setMine(userId.equals(centerUserId));
        return centerInfo;
    }
}
