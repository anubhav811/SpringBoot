package com.anubhav.springboot.demo.springbootfirst.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Controller {

//   injecting properties from application.properties

//    @Value("${coach.name}")
//    private String coachName;
//    @Value("${team.name}")
//    private String teamName;
//
//    @GetMapping("/teaminfo")
//    public String teamDetails(){
//        return "Coach :" + coachName + ", Team Name : " + teamName;
//    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }
    @GetMapping("/workout")
    public String getDay() {
        return "Monday";
    }
}
