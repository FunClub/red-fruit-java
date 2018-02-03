package com.taomei.redfruit.api.wechat.article.data;

/**
 * 微信文章响应体
 */
public class ArticleResponse {
    /**
     * 状态码
     */
    private String status;

    /**
     * 消息
     */
    private String msg;

    /**
     * 微信文章分页数据
     */
    private ArticleResult result;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArticleResult getResult() {
        return result;
    }

    public void setResult(ArticleResult result) {
        this.result = result;
    }
}
