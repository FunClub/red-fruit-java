package com.taomei.redfruit.api.wechat.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taomei.redfruit.api.common.ApiService;
import com.taomei.redfruit.api.wechat.article.data.Article;
import com.taomei.redfruit.api.wechat.article.data.ArticleResponse;
import com.taomei.redfruit.common.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信文章服务
 */
@Service
public class ArticleService extends ApiService{

    /**
     * 配置
     */
    private ArticleConfiguration configuration;

    /**
     * 初始化请求头部信息
     */
    @Autowired
    public ArticleService(ArticleConfiguration configuration) {
        super(configuration.getHost(),configuration.getPath(),configuration.getAppCode(),configuration.getMethod());
    }

    /**
     * 获取文件
     * @param channelId 频道ID
     * @param startIndex 文章索引，从零开始
     * @param amountOfArticle 文章数量
     * @return 文章集合
     * @throws Exception
     */
    public List<Article> getArticle(String channelId, String startIndex, String amountOfArticle) throws Exception {
        queries.put("start",startIndex);
        queries.put("num",amountOfArticle);
        queries.put("channelid", channelId);
        String body = doGet();
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleResponse articles = objectMapper.readValue(body,ArticleResponse.class);
        return articles.getResult().getList();
    }
}
