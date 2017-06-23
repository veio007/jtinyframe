package com.veio007.jtinyframe.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil {
    @Autowired
    private ContextRefresher contextRefresher;

    public ContextRefresher getContextRefresher() {
        return contextRefresher;
    }

    public void refresh() {
        contextRefresher.refresh();
    }
}
