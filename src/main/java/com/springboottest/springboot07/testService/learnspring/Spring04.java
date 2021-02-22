package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @description:
 * @date: 2021/1/21
 **/

@Configuration
public class Spring04 {

    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

        return configurer;
    }

    public PropertyOverrideConfigurer overrideConfigurer(){
        PropertyOverrideConfigurer configurer = new PropertyOverrideConfigurer();

        return configurer;
    }

}
