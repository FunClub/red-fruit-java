package com.taomei.redfruit.business.trend.application.repository;

import com.baomidou.mybatisplus.service.IService;
import com.taomei.redfruit.business.trend.infrastructure.po.Album;

import java.util.List;

/**
 * 相册仓储接口
 */
public interface AlbumRepository extends IService<Album> {

    /**
     * 通过用户 id 查询用户相册
     *
     * @param userId 用户 id
     * @return 相册列表
     */
    List<Album> queryCenterAlbum(String userId);
}
