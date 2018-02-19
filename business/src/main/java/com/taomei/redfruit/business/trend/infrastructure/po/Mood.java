package com.taomei.redfruit.business.trend.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 心情
 */
@Data
public class Mood extends Trend{

    /**
     * 心情 Id
     */
    @TableId
    private String moodId;
    /**
     * 内容
     */
    private String content;

    /**
     * 视频
     */
    private String video;

    @TableField(exist = false)
    private List<String> imgs;
}
