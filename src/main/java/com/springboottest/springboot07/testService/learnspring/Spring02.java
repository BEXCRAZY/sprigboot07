package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2021/1/21
 **/

@Component
public class Spring02 {

    @Autowired
    private ObjectFactoryCreatingFactoryBean spring02Bean;

    public void setSpring02Bean(ObjectFactoryCreatingFactoryBean bean){
        this.spring02Bean = bean;
    }

    public Spring01 getInstance() throws Exception {
        return (Spring01) spring02Bean.getObject();
    }


}
