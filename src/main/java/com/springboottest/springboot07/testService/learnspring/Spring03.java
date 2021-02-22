package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description: 继承factoryBean   可实现工厂方法返回对象实例   对象的引用类型为 此例的 getObjectType 返回类型  见01
 * @date: 2021/1/21
 **/

@Component("spring03")
public class Spring03 implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return LocalDateTime.now().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return LocalDateTime.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
