package com.taomei.redfruit.api.wechat.article;

import com.taomei.redfruit.api.common.ApiConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信文章配置类
 */
@ConfigurationProperties(prefix = "api.wechat.article")
@Component
public class ArticleConfiguration extends ApiConfiguration {

}
