package com.taomei.redfruit.api.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件服务，主要提供将文件上传到oss，以及从oss中删除文件
 */
@Service
public class OssService {
    public static final String BANNER = "banner";
    public static final String PROFILE = "profile";
    public static final String ALBUM = "album";
    public static final String MOOD = "mood";
    /**
     * OSS客户端
     */
    private OSSClient client;

    /**
     * OSS配置
     */
    private OssConfiguration configuration;


    @Autowired
    public OssService(OssConfiguration configuration) {
        this.configuration = configuration;
        client =new OSSClient(
                configuration.getEndpoint(),
                configuration.getAccessKeyID(),
                configuration.getAccessKeySecret()
        );
    }

    /**
     * 上传文件集合并生成路径
     * @param files 上传的文件集合
     * @param folder 存储空间文件夹
     * @return 文件地址 集合
     * @throws IOException 文件IO异常
     */
    public List<String> uploadInBatches(List<MultipartFile> files, String folder) throws IOException {
        List<String> imgPath = new ArrayList<>();
        for(MultipartFile file:files){
            imgPath.add(upload(file,folder));
        }
        return imgPath;
    }

    /**
     * 上传文件并生成路径
     * @param file 上传的文件
     * @param folder 存储空间文件夹
     * @return 文件地址
     * @throws IOException
     */
    public String upload (MultipartFile file,String folder) throws IOException {
        ObjectMetadata meta = new ObjectMetadata();
        InputStream inputStream = file.getInputStream();
        String imageName =folder+"/"+ UUID.randomUUID()+file.getOriginalFilename();
        meta.setContentLength(file.getBytes().length);
        client.putObject(configuration.getBucketName(),imageName,inputStream,meta);
        return imageName;
    }

    /**
     * 根据指定路径删除文件
     * @param path 文件路径
     */
    public void delete(String path){
        client.deleteObject(configuration.getBucketName(),path);
    }

    /**
     * 批量删除文件
     * @param paths 文件路径集合
     */
    public void deleteInBatches(List<String> paths){
        for (String path:paths){
            delete(path);
        }
    }
}
