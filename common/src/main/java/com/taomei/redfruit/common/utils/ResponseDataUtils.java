package com.taomei.redfruit.common.utils;

import com.taomei.redfruit.common.response.HttpStatus;
import com.taomei.redfruit.common.response.ResponseData;

/**
 * 响应数据工具类
 */
public class ResponseDataUtils {

    /**
     * 生成成功完成请求的数据
     * @param data 业务数据
     * @return 响应给前端的统一格式数据
     */
    public static ResponseData success(Object data){
        ResponseData responseData = new ResponseData();
        responseData.setData(data);
        responseData.setCode(HttpStatus.SUCCESS.getCode());
        responseData.setMessage(HttpStatus.SUCCESS.getMessage());
        return responseData;
    }

    /**
     * 系统发生错误时返回的数据
     * @param message 错误消息
     * @return 响应给前端的统一格式数据
     */
    public static ResponseData Error(String message){
        ResponseData responseData = new ResponseData();
        responseData.setCode(HttpStatus.ERROR.getCode());
        responseData.setMessage(message);
        return responseData;
    }

    /**
     * 响应未成功完成请求的数据
     * @param message 错误消息
     * @return 响应给前端的统一格式数据
     */
    public static ResponseData failed(String message){
        ResponseData responseData = new ResponseData();
        responseData.setCode(HttpStatus.FAILED.getCode());
        responseData.setMessage(message);
        return responseData;
    }
}
