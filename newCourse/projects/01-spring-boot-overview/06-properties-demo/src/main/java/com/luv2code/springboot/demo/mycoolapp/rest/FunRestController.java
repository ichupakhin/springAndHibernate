package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //inject properties from application.properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/coachname")
    public String getCoachName() {
        return coachName;
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String geDailyWorkout() {
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String geDailyFortune() {
        return "Today is your lucky day";
    }
}
