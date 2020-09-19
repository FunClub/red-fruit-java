package com.taomei.redfruit.business.trend.presentation;

import com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId;
import com.taomei.redfruit.business.trend.application.dto.AddPhotoComm;
import com.taomei.redfruit.business.trend.application.service.AlbumService;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 相册控制器
 */
@RestController
@RequestMapping("/trend/album/")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 添加相片
     * @param comm 添加相片dto
     * @return 展示相片信息的dto
     */
    @PostMapping("photo")
    @SetUserId
    public Object addPhoto(String userId, @RequestBody AddPhotoComm comm) throws Exception {
        return albumService.insertPhotos(comm);
    }

    /**
     * 创建相册
     * @param album 相册
     * @param userId  用户 id
     * @return 创建成功的相册
     */
    @PostMapping("")
    @SetUserId
    public Object createAlbum(String userId,@RequestBody Album album){
        album.setUserId(userId);
        return albumService.create(album);
    }

    /**
     * 通过用户 id 查询用户相册
     * @param userId 用户 id
     * @return 相册列表
     */
    @GetMapping("{userId}")
    public Object queryCenterAlbum(@PathVariable("userId") String userId){
        return albumService.queryCenterAlbum(userId);
    }

    /**
     * 生成上传相片的预览
     * @param imgs 图片文件
     * @param folder 文件夹
     * @return 相片预览
     * @throws IOException
     */
    @PostMapping("/{folder}/preUpload")
    public Object upLoadPhoto(@PathVariable("folder") String folder, @RequestParam("imgs") List<MultipartFile> imgs) throws IOException {
        return albumService.generateUpLoadPhotoDto(imgs, folder);
    }
}
