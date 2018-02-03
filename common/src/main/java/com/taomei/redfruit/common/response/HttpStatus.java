package com.taomei.redfruit.common.response;

public enum HttpStatus {

    SUCCESS(200,"处理成功!"),

    /**
     * 系统错误
     */
    ERROR(500,"处理失败"),

    /**
     * 处理业务失败
     */
    FAILED(600,"处理失败"),

    NOT_FOUND(404,"请求的数据不存在")
    ;
    private Integer code;
    private String message;

    HttpStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
