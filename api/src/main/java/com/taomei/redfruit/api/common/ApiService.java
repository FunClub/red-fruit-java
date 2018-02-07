package com.taomei.redfruit.api.common;

import com.taomei.redfruit.common.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * api共用服务
 */
public class ApiService {

    /**
     * 请求头部参数
     */
    protected Map<String,String> headers;

    /**
     * 查询参数
     */
    protected Map<String,String> queries;

    /**
     * 主机
     */
    private String host;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 请求方法
     */
    private String method;



    public ApiService(String host,String path, String appCode,String method) {
        this.headers = new HashMap<>();
        this.queries = new HashMap<>();
        this.method = method;
        this.host = host;
        this.path = path;
        headers.put("Authorization", "APPCODE " + appCode);
    }

    /**
     * 发起Get请求
     * @return 响应体
     * @throws Exception
     */
    protected String doGet() throws Exception {
        HttpResponse response =HttpUtils.doGet(host, path, method, headers, queries);
        return EntityUtils.toString(response.getEntity());
    }

}
