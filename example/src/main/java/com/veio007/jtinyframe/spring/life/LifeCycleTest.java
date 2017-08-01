package com.veio007.jtinyframe.spring.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 参考：http://www.cnblogs.com/zrtqsk/p/3735273.html
 *
 * 1、Bean自身的方法
 * 这个包括了Bean本身调用的方法和通过配置文件中<bean>的init-method和destroy-method指定的方法
 * 2、Bean级生命周期接口方法
 * 这个包括了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这些接口的方法
 * 3、容器级生命周期接口方法
 * 这个包括了InstantiationAwareBeanPostProcessor 和 BeanPostProcessor 这两个接口实现，
 * 一般称它们的实现类为“后处理器”。
 * 4、工厂后处理器接口方法
 * 这个包括了AspectJWeavingEnabler, ConfigurationClassPostProcessor, CustomAutowireConfigurer等等
 * 非常有用的工厂后处理器　　接口的方法。工厂后处理器也是容器级的。在应用上下文装配配置文件之后立即调用


 ClassPathBeanDefinitionScanner.doScan 扫描bean
 */
@Component
public class LifeCycleTest extends InstantiationAwareBeanPostProcessorAdapter
        implements BeanFactoryPostProcessor, BeanPostProcessor, BeanNameAware,
        BeanFactoryAware, InitializingBean, DisposableBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
    }

    // 实例化BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("ok");
    }

    // 实例化BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    // BeanNameAware
    @Override
    public void setBeanName(String name) {
    }

    // BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }

    // InstantiationAwareBeanPostProcessorAdapter
}
