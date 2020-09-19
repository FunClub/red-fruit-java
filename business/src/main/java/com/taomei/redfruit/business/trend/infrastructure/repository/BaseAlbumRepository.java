package com.taomei.redfruit.business.trend.infrastructure.repository;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.taomei.redfruit.business.info.application.repository.HalfRepository;
import com.taomei.redfruit.business.trend.application.repository.AlbumRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 相册仓储实现
 */
@Component
public class BaseAlbumRepository extends ServiceImpl<AlbumMapper,Album> implements AlbumRepository{

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private HalfRepository halfRepository;
    /**
     * 通过用户 id 查询用户相册
     * @param userId 用户 id
     * @return 相册列表
     */
    @Override
    public List<Album> queryCenterAlbum(String userId) {
        String halfUserId = halfRepository.selectHalfUserIdByUserId(userId);
        return albumMapper.findByHalf(userId,halfUserId);
    }
}
