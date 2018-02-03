package com.taomei.redfruit.api.wechat.article.data;

import com.taomei.redfruit.api.wechat.article.data.Article;

import java.util.List;

/**
 * 微信文章分页数据
 */
public class ArticleResult {
    private String channel;
    private String channelid;
    private String total;
    private String num;
    private String start;

    /**
     * 微信文章集合
     */
    private List<Article> list;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }
}
