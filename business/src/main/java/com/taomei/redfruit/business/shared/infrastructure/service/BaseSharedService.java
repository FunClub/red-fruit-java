package com.taomei.redfruit.business.shared.infrastructure.service;

import com.taomei.redfruit.business.info.application.repository.UserRepository;
import com.taomei.redfruit.business.info.infrastructure.po.User;
import com.taomei.redfruit.business.shared.application.SharedService;
import com.taomei.redfruit.business.shared.application.dto.TitleUserInfo;
import com.taomei.redfruit.business.shared.infrastructure.annotation.SetUserId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseSharedService implements SharedService{
    @Autowired
    private UserRepository userRepository;
    /**
     * 获取用户主页标题信息
     *
     * @param userId 用户Id
     * @return 标题信息
     */
    @Override
    public TitleUserInfo selectTitleUserInfo(String userId) {
        User user=userRepository.selectById(userId);
        TitleUserInfo info = new TitleUserInfo();
        BeanUtils.copyProperties(user,info);
        return info;
    }
}
