package com.taomei.redfruit.business.info.presentation;

import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.info.application.dto.UserCriterionInfo;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户搜索控制器
 */
@RestController
@RequestMapping("/user/search/")
public class SearchController {
    @Autowired
    private InfoService infoService;

    /**
     * 根据条件分页查询用户
     * @param userPageComm 分页条件
     * @return 已分页的用户信息
     */
    @PostMapping("")
    public Object getSearchUserInfo(@RequestBody PageComm<User,UserCriterionInfo> userPageComm){
        return infoService.selectUsersBySearch(userPageComm);
    }

    /**
     * 查询用户的择偶信息
     * @param userId 用户id
     * @return 择偶信息
     */
    @GetMapping("criterion")
    @SetUserId
    public Object getUserCriterionInfo(String userId){
        return infoService.selectUserCriterionInfo(userId);
    }

}
