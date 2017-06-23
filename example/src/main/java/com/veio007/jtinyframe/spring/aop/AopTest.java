package com.veio007.jtinyframe.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop生效条件：
 * 1 依赖包spring-aop aspectjrt aspectjweaver cglib
 * 2 被切面的函数所属对象归spring管理，就是要是bean对象的方法
 * 3 使用注解@EnableAspectJAutoProxy激活aop功能
 * 4 对增强类使用@Aspect @Component
 * 5 正确使用切点
 */

@SpringBootApplication(scanBasePackages = "com.veio007.jtinyframe.spring.aop")
@EnableAspectJAutoProxy
public class AopTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(AopTest.class, args);
        AopService aopService = applicationContext.getBean(AopService.class);
        System.out.println(aopService.service());
    }

}