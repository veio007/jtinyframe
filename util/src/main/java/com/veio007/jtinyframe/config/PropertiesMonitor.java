package com.veio007.jtinyframe.config;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PropertiesMonitor implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        // 监控文件变化
        Resource resource = new ClassPathResource("application.properties");

        FileAlterationObserver obs = new FileAlterationObserver(
                FilenameUtils.getFullPath(resource.getFile().getPath()));
        obs.addListener(new FileAlterationListenerAdaptor(){
            public void onFileChange(File file) {
                System.out.println(file.getName() + " changed");
                contextRefresher.refresh();
            }
        });

        FileAlterationMonitor monitor  = new FileAlterationMonitor(1000, obs);
        monitor.start();
    }

    @Autowired
    private ContextRefresher contextRefresher;
}
