package com.veio007.jtinyframe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EnableScheduling
public class ConfigTest {
    public static void main(String[] args) {
        SpringApplication.run(ConfigTest.class, args);
    }


    @Scheduled(cron = "0/10 * * * * ?")
    public void test() {
        System.out.println(config.getT1());
    }

    @Autowired
    private Config config;
}
