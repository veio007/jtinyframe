package com.veio007.jtinyframe.spring.aop.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAdvisor {
    @Around("execution(public * com.veio007.jtinyframe.spring.aop.AopService.*(..))")
    public Object aop(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = joinPoint.proceed();
        System.out.println("ok");
        return "ok";
    }
}
