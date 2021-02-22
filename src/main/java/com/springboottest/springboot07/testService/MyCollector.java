package com.springboottest.springboot07.testService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @description: 自定义collector
 * @date: 2020/11/16
 **/
public class MyCollector<T> implements Collector<T, List<T>,List<T>>{

    ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("classpath:a.xml");

    @Override
    public Supplier supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>,T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T> > combiner() {
        return (list1,list2)-> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>,List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT));
    }
}
