package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

//No @Component annotation. Instead it, use @Bean in com.luv2code.springcoredemo.config.SportConfig.swimCoach()
public class SwimCoach implements Coach {

    public SwimCoach()
    {
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meter";
    }
}
