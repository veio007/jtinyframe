package com.veio007.jtinyframe.spring.aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class AopRecordLog {


    // 记录日志
    @Around("execution(public * com.tianwen.springcloud.component.controller.ConvertController.*(..))")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimeMillis = System.currentTimeMillis();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        Map<String, String[]> inputParamMap = request.getParameterMap();
        String requestPath = request.getRequestURI();
        Object result = joinPoint.proceed();
        long endTimeMillis = System.currentTimeMillis();
        /*logger.info("\n"
                + "Begin:" + "\n"
                + "Url:" + requestPath + "\n"
                + "RequestParams:" + JSONObject.toJSON(inputParamMap) + "\n"
                + "ResponseResults:" + JSONObject.toJSON(result) + "\n"
                + "Cost:" + (endTimeMillis - startTimeMillis) + " ms " + "\n"
                + "End" + "\n");*/
        return request;
    }
}
