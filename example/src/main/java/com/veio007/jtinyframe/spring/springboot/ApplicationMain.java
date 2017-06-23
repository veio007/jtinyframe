package com.veio007.jtinyframe.spring.springboot;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
// 开启定时任务功能 检查获取动态配置 修改生效
@EnableScheduling
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(ApplicationMain.class, args);
        final SpringUtil springUtil = applicationContext.getBean(SpringUtil.class);

        // 监控文件变化
        Resource resource = new ClassPathResource("application.properties");

        FileAlterationObserver obs = new FileAlterationObserver(
                FilenameUtils.getFullPath(resource.getFile().getPath()));
        obs.addListener(new FileAlterationListenerAdaptor(){
            public void onFileChange(File file) {
                System.out.println(file.getName() + " changed");
                springUtil.refresh();
            }
        });

        FileAlterationMonitor monitor  = new FileAlterationMonitor(1000, obs);
        monitor.start();
    }
}
