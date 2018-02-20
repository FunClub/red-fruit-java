package com.taomei.redfruit.business.shared.presentation;

import com.taomei.redfruit.api.area.AreaService;
import com.taomei.redfruit.api.oss.OssService;
import com.taomei.redfruit.business.shared.application.SharedService;
import com.taomei.redfruit.business.shared.application.dto.InsertParentDiscussionComm;
import com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 共享控制器
 */
@RestController
@RequestMapping("/shared/")
public class SharedController {

    /**
     * 文件服务
     */
    @Autowired
    private OssService ossService;
    /**
     * 区域服务
     */
    @Autowired
    private AreaService areaService;

    /**
     * 共享服务
     */
    @Autowired
    private SharedService sharedService;

    /**
     * 添加父评论
     * @param userId 用户 Id
     * @param comm 命令
     * @return 父级评论信息
     */
    @PostMapping("/parentDiscussion")
    @SetUserId
    public Object create(String userId, @RequestBody InsertParentDiscussionComm comm){
        comm.getDiscussion().setUserId(userId);
        comm.getTrendNotice().setNoticeUserId(userId);
        return sharedService.createParentDiscussion(comm);
    }

    /**
     * 删除文件
     * @param filePaths 文件路径
     * @return 删除结果
     * @throws Exception
     */
    @PatchMapping("file")
    public Object delete(@RequestBody List<String> filePaths) throws Exception {
        ossService.deleteInBatches(filePaths);
        return true;
    }
    /**
     * 上传文件并生成路径
     * @param files 文件
     * @param folder 上传的文件夹
     * @return 路径
     * @throws IOException
     */
    @PostMapping("file/{folder}")
    public Object upload(@RequestParam("file") List<MultipartFile> files, @PathVariable("folder") String folder) throws IOException {
        return ossService.uploadInBatches(files,folder);
    }

    /**
     * 获取用户主页标题信息
     * @param userId 用户Id
     * @return 标题信息
     */
    @GetMapping("titleUser")
    @SetUserId
    public Object getTitleUserInfo(String userId){
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
