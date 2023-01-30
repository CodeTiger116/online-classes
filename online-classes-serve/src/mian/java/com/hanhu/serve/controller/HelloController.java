package com.hanhu.serve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/student/basic/hello")
    public String hello2(){
        return "/student/basic/**";
    }

    @GetMapping("/student/other/hello")
    public String hello3(){
        return "/student/other/**";
    }
}
