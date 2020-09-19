package com.taomei.redfruit.business.trend.infrastructure.service;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.taomei.redfruit.api.oss.OssService;

import com.taomei.redfruit.business.trend.application.dto.AddPhotoComm;
import com.taomei.redfruit.business.trend.application.dto.PhotoInfo;
import com.taomei.redfruit.business.trend.application.dto.TrendDtoAssembler;
import com.taomei.redfruit.business.trend.application.dto.UploadPhotoInfo;
import com.taomei.redfruit.business.trend.application.repository.AlbumRepository;
import com.taomei.redfruit.business.trend.application.repository.PhotoRepository;
import com.taomei.redfruit.business.trend.application.service.AlbumService;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;
import com.taomei.redfruit.business.trend.infrastructure.po.Photo;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 相册服务实现
 */
@Service
public class BaseAlbumService implements AlbumService{

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private OssService ossService;

    @Autowired
    private TrendDtoAssembler trendDtoAssembler;
    /**
     * 添加相片
     *
     * @param dto 添加相片dto
     * @return 展示相片信息的dto
     */
    @Override
    public List<PhotoInfo> insertPhotos(AddPhotoComm dto) throws Exception {
        //插入相片
        String albumId = dto.getAlbumId();
        String userId = dto.getUserId();
        List<Photo> photos = dto.getPhotos();
        Photo photo=null;
        for(int i=photos.size()-1;i>=0;i--){
            photo= photos.get(i);
            photo.setUploadDate(TimeUtils.generateDateTimeString());
            photo.setUserId(userId);
            //效果默认值不保存
            if(photo.getBlurR()==0){
                photo.setBlurR(null);
            }
            if(photo.getBlurS()==0){
                photo.setBlurS(null);
            }
            if(photo.getContrast()==0){
                photo.setContrast(null);
            }
            if(photo.getSharpen()==50){
                photo.setSharpen(null);
            }
            if(photo.getBright()==0){
                photo.setBright(null);
            }
        }

        //添加相片
        boolean addPhotoSuccess= photoRepository.insertBatch(photos);

        //更新相册更新时间
        boolean updateDateSuccess = updateDate(albumId);

        if(!(updateDateSuccess&&addPhotoSuccess)){throw new Exception("添加相片失败");}
        List<PhotoInfo> showPhotoDtos = new ArrayList<>();
        for (Photo photo1 : photos) {
            showPhotoDtos.add(trendDtoAssembler.assemblePhotoInfo(photo1,null));
        }
        return showPhotoDtos;
    }

    /**
     * 更新相册修改时间
     *
     * @param albumId 相册id
     * @return 修改结果
     */
    private boolean updateDate(String albumId) {
        Album album = new Album();
        album.setAlbumId(albumId);
        album.setDate(TimeUtils.generateDateTimeString());
        return albumRepository.updateById(album);
    }


    /**
     * 生成上传相片的预览
     * @param files 文件jihe
     * @param folder 文件夹
     * @return
     * @throws IOException
     */
    public List<UploadPhotoInfo> generateUpLoadPhotoDto(List<MultipartFile> files, String folder) throws IOException {
        List<UploadPhotoInfo> dtos = new ArrayList<>();
        for(MultipartFile file:files){
            UploadPhotoInfo dto = new UploadPhotoInfo();
            //生成图片的路径
            String path = ossService.upload(file,folder);

            //得到高度
            InputStream in = file.getInputStream();
            BufferedImage bi = ImageIO.read(in);
            int width = bi.getWidth();
            int height = bi.getHeight();

            //计算水印字体大小
            double orFontSize=15;//图片大小为300X400

            //如过图片过小就设置不缩放,水印字体大小为12否则就计算。
            if(height>=400&&width>=300 ||height>=300&&width>400){
                if(height>width){
                    double i = ((height-400)/88.0)*0.5;
                    orFontSize+=i;
                    i=((width-300)/66.0)*0.5;
                    orFontSize+=i;
                }else{
                    double i = ((width-400)/88.0)*0.5;
                    orFontSize+=i;
                    i=((height-300)/66.0)*0.5;
                    orFontSize+=i;
                }
                dto.setFontSize((int) orFontSize);
                dto.setZoomSize(calculateZoomSize(width,height));
            }else{
                dto.setFontSize(12);
                dto.setZoomSize(100);
            }

            dto.setPath(path);
            dto.setHeight(height);
            dto.setWidth(width);
            dto.setName(file.getOriginalFilename());
            dtos.add(dto);
        }
        return dtos;
    }
    private int calculateZoomSize(int width,int height){
        int p;
        if(height>width){
            p = (int) ((480.0/width)*100);
        }else{
            p= (int) ((380.0/height)*100);
        }
        return p;
    }
    /**
     * 通过用户 id 查询用户相册
     *
     * @param userId 用户 id
     * @return 相册列表
     */
    @Override
    public List<Album> queryCenterAlbum(String userId) {
        return albumRepository.queryCenterAlbum(userId);
    }



    /**
     * 创建相册
     *
     * @param album 相册
     * @return 创建成功的相册
     */
    @Override
    public Album create(Album album) {
        album.setDate(TimeUtils.generateDateTimeString());
        album.setCoverImg("static/pic-none.png");
        albumRepository.insert(album);
        return album;
    }


}
