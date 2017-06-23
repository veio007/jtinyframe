package com.veio007.jtinyframe.spring.httpservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

// 自动配置 类型安全配置
@ConfigurationProperties("spring.test")
@Component
@RefreshScope
public class Config {
    private String t1;
    private Integer t2;

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public Integer getT2() {
        return t2;
    }

    public void setT2(Integer t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Config{" +
                "t1='" + t1 + '\'' +
                ", t2=" + t2 +
                '}';
    }
}
