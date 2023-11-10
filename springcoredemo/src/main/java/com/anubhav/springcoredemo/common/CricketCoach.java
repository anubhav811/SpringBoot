package com.anubhav.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    // init method
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("PostConstruct doStartupStuff: "+getClass().getSimpleName());
    }
    // destroy method

    @PreDestroy
    public void doCleanUpStuff(){
        System.out.println("PreDestroy doCleanUpStuff: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Do fast bowling practice for 15 minutes :)";
    }
}
