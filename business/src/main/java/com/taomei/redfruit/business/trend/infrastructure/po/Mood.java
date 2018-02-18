package com.taomei.redfruit.business.trend.infrastructure.po;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 心情
 */
@Data
public class Mood extends Trend{
    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String imgStr;

    /**
     * 视频
     */
    private String video;

    @TableField(exist = false)
    private List<String> imgs;
}
