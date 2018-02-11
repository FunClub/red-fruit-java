package com.taomei.redfruit.business.shared.application;

import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import org.springframework.stereotype.Service;

/**
 * 共享服务接口
 */
@Service
public interface SharedService {

    /**
     * 获取用户主页标题信息
     * @param userId 用户Id
     * @return 标题信息
     */
    TitleUserInfo selectTitleUserInfo(Long userId);
}
