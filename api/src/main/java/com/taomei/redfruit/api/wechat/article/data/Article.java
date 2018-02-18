package com.taomei.redfruit.api.wechat.article.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信文章
 */
@Data
public class Article {

    /**
     * 标题
     */
    private String title;

    /**
     * 时间
     */
    @JsonIgnore
    private String time;

    /**
     * 微信名
     */
    private String weixinname;

    /**
     * 微信号
     */
    @JsonIgnore
    private String weixinaccount;

    /**
     * 微信摘要
     */
    private String weixinsummary;

    @JsonIgnore
    private String channelid;

    /**
     * 图片
     */
    private String pic;

    @JsonIgnore
    private String content;

    /**
     * 文章链接
     */
    private String url;

    /**
     * 阅读总量
     */
    private String readnum;

    /**
     * 喜欢总量
     */
    private String likenum;

}
