package com.springboottest.springboot07.testService;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @date: 2021/1/15
 **/


@Aspect
@Component
public class helloAspect {

    @Pointcut("execution(public String com.springboottest.springboot07.testService.helloAOP.sayHello(String))")
    public void as(){}

    @Around("as()")
    public String arounfHello(ProceedingJoinPoint pj){

        System.out.println(pj.getSignature().getName());
        System.out.println(pj.getSignature().getDeclaringTypeName());
        System.out.println(pj.getThis());
        System.out.println(pj.getArgs()[0]);

        Object[] args = pj.getArgs();

        args[0]=args[0]+"jq";

        System.out.println("前置信息打印完毕   参数   "+args[0]);

        Object o = null;
        try {
            o = pj.proceed(args);
        } catch (Throwable throwable) {

            System.out.println("异常通知");
            throwable.printStackTrace();
        }

        System.out.println("后置通知");
        return o+"=============ok!";

    }


}
