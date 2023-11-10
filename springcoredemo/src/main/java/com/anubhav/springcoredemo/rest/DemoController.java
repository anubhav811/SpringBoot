package com.anubhav.springcoredemo.rest;

import com.anubhav.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    /*Constructor Annotation*/
    // Qualifier set because there are 4 Coach classes . Qualifier won't be required if a Primary Component is marked
    public DemoController(Coach theCoach){
        System.out.println("In Constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
    }
    /*Setter Injection*/
//    public void doSomeStuff(Coach theCoach){
//        myCoach = theCoach;
//    }

//    The above and below method will do the same thing . Because its annotated by @Autowired , Spring will automatically do setter injection
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
