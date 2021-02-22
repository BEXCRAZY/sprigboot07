package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @description: BeanFactoryAware  实现此接口  bean实例化时  拥有一个 beanFactory。
 * @date: 2021/1/21
 **/
@Component("spring01")
public class Spring01 implements BeanFactoryAware {

    @Autowired
    private LocalDateTime spring03;

    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }

}
