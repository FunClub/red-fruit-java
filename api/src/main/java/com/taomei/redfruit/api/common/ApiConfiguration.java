package com.taomei.redfruit.api.common;

/**
 * api通用配置
 */
public class ApiConfiguration {
    /**
     * 应用码
     */
    private String appCode;

    /**
     * 主机
     */
    private String host;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求路径
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
