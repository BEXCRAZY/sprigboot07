package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @description:
 * @date: 2021/1/21
 **/

@RestController
@RequestMapping("/p")
@PropertySources(@PropertySource({"classpath:a.properties","classpath:b.properties"}))
public class PlaceHolderConfiguragerTest {


    @Autowired
    private Environment environment;

    @Value("${p.name}")
    private String name;

    @Value("#{T(Math).random()*20}")
    private String he;

//    @Value("${p.date}")
//    private LocalDate date;


//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

    public void setName(String name) {
        this.name = name;
    }


    @RequestMapping("/name")
    @MyAnnotation
    public String getName(){

        System.out.println(environment.getProperty("m.name"));
        return this.name;
    }

    @RequestMapping("/date")
    public String getDate(LocalDate d){

        System.out.println(d);

        System.out.println(d.getDayOfWeek());

        LocalDate date = d.plus(-1, ChronoUnit.DAYS);




        return date.toString();

    }




}
