package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户资料控制器
 */
@RestController
@RequestMapping("/user/info/")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return 成功与否
     */
    @PutMapping("")
    @SetUserId
    public Object updateUserAllInfo(Long userId,@RequestBody User user){
        user.setId(userId);
        return infoService.updateUserInfo(user);
    }
    /**
     * 获取用户的全部信息
     * @param userId 用户id
     * @return 用户的全部信息
     */
    @GetMapping("{userId}")
    public Object getUserAllInfo(@PathVariable("userId") Long userId){
        return infoService.selectAllUserInfo(userId);
    }
}
