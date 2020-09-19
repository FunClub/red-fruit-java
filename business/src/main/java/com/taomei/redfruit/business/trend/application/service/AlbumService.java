package com.taomei.redfruit.business.trend.application.service;

import com.taomei.redfruit.business.trend.application.dto.AddPhotoComm;
import com.taomei.redfruit.business.trend.application.dto.PhotoInfo;
import com.taomei.redfruit.business.trend.application.dto.UploadPhotoInfo;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 相册服务接口
 */
public interface AlbumService {

    /**
     * 添加相片
     * @param comm 添加相片dto
     * @return 展示相片信息的dto
     */
    List<PhotoInfo> insertPhotos(AddPhotoComm comm) throws Exception;

    /**
     * 创建相册
     * @param album 相册
     * @return 创建成功的相册
     */
    Album create(Album album);

    /**
     * 通过用户 id 查询用户相册
     * @param userId 用户 id
     * @return 相册列表
     */
    List<Album> queryCenterAlbum(String userId);

    /**
     * 生成上传相片的预览
     * @param files 文件jihe
     * @param folder 文件夹
     * @return
     * @throws IOException
     */
    public List<UploadPhotoInfo> generateUpLoadPhotoDto(List<MultipartFile> files, String folder) throws IOException;
}
