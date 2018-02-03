package com.taomei.redfruit.common.exception;

import com.taomei.redfruit.common.response.HttpStatus;
import com.taomei.redfruit.common.response.ResponseData;
import com.taomei.redfruit.common.utils.ResponseDataUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 处理业务处理失败异常
     * @param exception 业务异常
     * @return 响应给前端的统一格式数据
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseData handleBusiness(BusinessException exception){
        return ResponseDataUtils.failed(exception.getMessage());
    }

    /**
     * 处理系统错误异常
     * @param exception 系统异常
     * @return 响应给前端的统一格式数据
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData handle(Exception exception){
        return ResponseDataUtils.Error(exception.getMessage());
    }
}
