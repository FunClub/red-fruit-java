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
     * 验证昵称是否可被更新
     *
     * @param user 用户
     * @return
     */
    @GetMapping("/nickname")
    @SetUserId
    public Object nicknameCanUpdate(String userId,User user){
        user.setId(userId);
        return infoService.nicknameCanUpdate(user);
    }
    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return 成功与否
     */
    @PutMapping("")
    @SetUserId
    public Object updateUserAllInfo(String userId,@RequestBody User user){
        user.setId(userId);
        return infoService.updateUserInfo(user);
    }
    /**
     * 获取用户的全部信息
     * @param userId 用户id
     * @return 用户的全部信息
     */
    @GetMapping("{userId}")
    public Object getUserAllInfo(@PathVariable("userId") String userId){
        return infoService.selectAllUserInfo(userId);
    }
}
