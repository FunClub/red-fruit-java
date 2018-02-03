package com.taomei.redfruit.common.response;

import com.taomei.redfruit.common.utils.ResponseDataUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 将控制器返回的业务数据封装成统一格式数据
 * @see ResponseData
 * @see ResponseDataUtils
 */
@Aspect
@Component
public class ResponseAspect {

    @Around("bean(*Controller)")
    public Object handle(ProceedingJoinPoint pjp) throws Throwable {
        Object data=pjp.proceed();
        return ResponseDataUtils.success(data);
    }
}
