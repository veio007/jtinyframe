package com.veio007.jtinyframe.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.io.FileInputStream;

// 文件监控 文件修改监控 目录监控
public class Monitor {
    public static void main(String[] args) throws Exception {
        FileAlterationObserver obs = new FileAlterationObserver(
                new File("D:\\work\\project\\jtinyframe\\example\\src\\main\\resources"));
        obs.addListener(new FileAlterationListenerAdaptor(){
            public void onFileChange(File file) {
                System.out.println(file.getName() + " changed");
            }
        });

        FileAlterationMonitor monitor  = new FileAlterationMonitor(1000, obs);
        monitor.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
