package com.taomei.redfruit.common.response;

/**
 * 响应给前端的统一格式数据
 */
public class ResponseData {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 应答消息
     */
    private String message;

    /**
     * 业务数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
