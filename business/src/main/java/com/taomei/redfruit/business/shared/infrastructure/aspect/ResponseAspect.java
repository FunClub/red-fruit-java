package com.taomei.redfruit.business.shared.infrastructure.aspect;

import com.taomei.redfruit.common.response.ResponseData;
import com.taomei.redfruit.common.utils.ResponseDataUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 将控制器返回的业务数据封装成统一格式数据
 * @see ResponseData
 * @see ResponseDataUtils
 */
@Aspect
@Component
public class ResponseAspect {

    @Around("bean(*Controller) && !@annotation(com.taomei.redfruit.business.shared.infrastructure.aspect.annotation.SetUserId)")
    public Object handle(ProceedingJoinPoint pjp) throws Throwable {
        Object data=pjp.proceed();
        return ResponseDataUtils.success(data);
    }
}