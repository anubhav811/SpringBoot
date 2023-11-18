package com.anubhav.spring.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class DemoRestController {

    // add code for "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World !";
    }
}
