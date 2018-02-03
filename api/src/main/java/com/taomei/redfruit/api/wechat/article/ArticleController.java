package com.taomei.redfruit.api.wechat.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信文章控制器
 */
@RestController
@RequestMapping("api/wechat/article")
public class ArticleController {

    /**
     * 文章服务
     */
    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表
     * @param channelId 频道ID
     * @param startIndex 文章开始索引
     * @param amountOfArticle  文章数量
     * @return 文章集合
     * @throws Exception
     */
    @GetMapping("/{channelId}/{startIndex}/{amountOfArticle}")
    public Object getArticles(@PathVariable("channelId") String channelId, @PathVariable("startIndex") String startIndex, @PathVariable("amountOfArticle") String amountOfArticle) throws Exception {
        return articleService.getArticle(channelId,startIndex,amountOfArticle);
    }
}
