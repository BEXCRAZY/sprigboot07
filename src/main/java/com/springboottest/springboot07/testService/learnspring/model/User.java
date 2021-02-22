package com.springboottest.springboot07.testService.learnspring.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @date: 2021/2/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private int age;

}
