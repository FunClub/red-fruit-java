package com.taomei.redfruit.business.shared.presentation;

import com.taomei.redfruit.api.area.AreaService;
import com.taomei.redfruit.business.shared.application.SharedService;
import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import com.taomei.redfruit.common.utils.ValidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 共享控制器
 */
@RestController
@RequestMapping("/shared/")
public class SharedController {
    /**
     * 区域服务
     */
    @Autowired
    private AreaService areaService;

    @Autowired
    private SharedService sharedService;

    /**
     * 获取用户主页标题信息
     * @param userId 用户Id
     * @return 标题信息
     */
    @GetMapping("titleUser")
    @SetUserId
    public Object getTitleUserInfo(Long userId){
        return  sharedService.selectTitleUserInfo(userId);
    }


    /**
     * 获取父级区域集合
     * @param leave 行政区域等级（0: 省级 1:市级 2:县级 3:镇级 4:乡村级）
     * @param pageNumber 页码，从1开始
     * @param pageSize 每页区域数
     * @return 区域集合
     * @throws Exception
     */
    @GetMapping("parent/{leave}/{pageNumber}/{pageSize}")
    public Object getParentArea(@PathVariable("leave") String leave, @PathVariable("pageNumber") String pageNumber, @PathVariable("pageSize") String pageSize) throws Exception {
        return areaService.getParentArea(leave,pageNumber,pageSize);
    }

    /**
     * 获取指定id的子级区域集合
     * @param parentId 父级区域id
     * @return 区域集合
     * @throws Exception
     */
    @GetMapping("sub/{parentId}")
    public Object getSubArea(@PathVariable("parentId") String parentId) throws Exception {
        return areaService.getSubArea(parentId);
    }
}
