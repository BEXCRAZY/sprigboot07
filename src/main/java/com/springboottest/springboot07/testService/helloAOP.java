package com.springboottest.springboot07.testService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2021/1/15
 **/

@RestController() //responsebody和controller
@RequestMapping(value = "/hello")
public class helloAOP {

    @GetMapping(value = "/p")
    public String sayHello (@RequestParam(value = "m",required = false) String m){

        return "hello----"+m;
    }

}
