package com.springboottest.springboot07.testService.learnspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @date: 2021/1/22
 **/
@Component
public class ConventorTest implements Converter<String, LocalDate> {

    @Value("p.pattern")
    private String pattern;

    @Override
    public LocalDate convert(String s) {
        LocalDate date = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy=MM=dd"));
        return date;
    }
}
