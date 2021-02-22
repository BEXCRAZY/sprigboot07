package com.springboottest.springboot07.testService.learnspring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2021/1/27
 **/
@Aspect
@Component
@Profile("dev")
public class AspectTest implements Ordered {

    @Pointcut("@annotation(MyAnnotation)")
    public void myAnnotation(){}


    @Around("myAnnotation()")
    public String ProxyIt(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("iam run");
        Object o = joinPoint.proceed();
        System.out.println("iam ok!");

        return o+"55555";

    }


    @Override
    public int getOrder() {
        return 5;
    }
}
