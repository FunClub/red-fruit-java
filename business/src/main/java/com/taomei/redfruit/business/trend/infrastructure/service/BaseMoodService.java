package com.taomei.redfruit.business.trend.infrastructure.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.taomei.redfruit.business.info.application.InfoService;
import com.taomei.redfruit.business.shared.application.dto.PageComm;
import com.taomei.redfruit.business.shared.application.dto.PagedInfo;
import com.taomei.redfruit.business.shared.application.dto.QueryOtherComm;
import com.taomei.redfruit.business.shared.application.repository.ImgRepository;
import com.taomei.redfruit.business.shared.infrastructure.repository.BaseImgRepository;
import com.taomei.redfruit.business.shared.infrastructure.repository.ImgMapper;
import com.taomei.redfruit.business.trend.application.MoodService;
import com.taomei.redfruit.business.trend.application.dto.MoodInfo;
import com.taomei.redfruit.business.trend.application.dto.QueryMoodComm;
import com.taomei.redfruit.business.trend.application.dto.TrendDtoAssembler;
import com.taomei.redfruit.business.trend.application.repository.MoodRepository;
import com.taomei.redfruit.business.trend.infrastructure.po.Img;
import com.taomei.redfruit.business.trend.infrastructure.po.Mood;
import com.taomei.redfruit.common.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 心情服务实现类
 */
@Service
public class BaseMoodService implements MoodService{

    @Autowired
    private MoodRepository moodRepository;

    @Autowired
    private InfoService infoService;

    @Autowired
    private ImgRepository imgRepository;

    /**
     * 通过个人中心查询心情
     *
     * @param pageComm 分页命令
     * @return 分页心情数据
     */
    @Override
    public PagedInfo getMoodByCenter(PageComm<MoodInfo,QueryOtherComm> pageComm) {
        QueryOtherComm otherComm = pageComm.getCondition();
        Page<MoodInfo> moodPage = pageComm.getPage();
        //查询用户另一半 id
        String halfUserId = infoService.getHalfUserId(otherComm.getOfUserId());
        List<String> userIds = new ArrayList<>();
        if(halfUserId!=null){
            userIds.add(halfUserId);
        }
        userIds.add(otherComm.getOfUserId());
        moodPage = moodRepository.selectByUserIds(moodPage,userIds);
        return TrendDtoAssembler.assembleMoodInfo(moodPage,otherComm.getViewUserId());
    }

    /**
     * 创建心情
     *
     * @param mood  心情
     * @return 创建结果
     */
    @Override
    @Transactional
    public boolean create(Mood mood) {
        mood.setDate(TimeUtils.generateDateTimeString());

        //插入心情
        moodRepository.insert(mood);

        //插入心情图片
        List<String> imgs = mood.getImgs();
        if(imgs.size()!=0){
            List<Img> imgsObj = new ArrayList<>();
            for (String img:imgs){
                imgsObj.add(new Img(mood.getMoodId(),img));
            }
            imgRepository.insertBatch(imgsObj);
        }
        return true;
    }


    /**
     * 删除动态
     *
     * @param trendId 动态ID
     * @return 删除结果
     */

    public boolean delete(String trendId) {
        return false;
    }
}
