package com.springboottest.springboot07.testService.learnspring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2021/1/27
 **/
@Component
@Aspect
public class AspectTest1 implements Ordered {
    @Override
    public int getOrder() {
        return 6;
    }

    @Around("@annotation(MyAnnotation)")
    public String odIt(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("1 run");

        Object o = joinPoint.proceed();

        System.out.println("1 ok!");

        return o+"22222";
    }

}
