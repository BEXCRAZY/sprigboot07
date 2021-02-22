package com.springboottest.springboot07.testService.learnspring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @description:
 * @date: 2021/1/25
 **/
public class MyPonitCut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return null;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return null;
    }

    class MyInterceptor implements MethodInterceptor{

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            return methodInvocation.proceed();
        }
    }


    public void test(){

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("getName");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(new MyInterceptor());

        ProxyFactory weaver = new ProxyFactory();
        weaver.setTarget(PlaceHolderConfiguragerTest.class);
        weaver.addAdvisor(advisor);
        Object proxy = weaver.getProxy();

        ProxyFactoryBean factoryBean = new ProxyFactoryBean();



    }
}
