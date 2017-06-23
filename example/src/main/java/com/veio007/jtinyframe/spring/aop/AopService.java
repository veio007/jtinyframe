package com.veio007.jtinyframe.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class AopService {
    public String service() {
        System.out.println("service");
        return "service";
    }
}
