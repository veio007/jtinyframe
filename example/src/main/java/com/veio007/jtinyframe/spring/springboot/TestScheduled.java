package com.veio007.jtinyframe.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduled {
    @Autowired
    private Config config;

    // 定时任务
    @Scheduled(cron = "0/10 * * * * ?")
    public void test() {
        System.out.println(config);
    }
}
