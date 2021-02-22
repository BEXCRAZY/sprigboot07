package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: ObjectFactoryCreatingFactoryBean 实现了BeanFactoryAware接口  拥有beanFactory实例，
 *               是Spring提供的一个FactoryBean实现，它返回一个 ObjectFactory实例
 * @date: 2021/1/21
 **/
@Configuration
public class ObjectFactoryBean {

    @Bean
    public ObjectFactoryCreatingFactoryBean spring02Bean(){

        ObjectFactoryCreatingFactoryBean bean = new ObjectFactoryCreatingFactoryBean();
        bean.setTargetBeanName("spring01");
        return bean;

    }
}
