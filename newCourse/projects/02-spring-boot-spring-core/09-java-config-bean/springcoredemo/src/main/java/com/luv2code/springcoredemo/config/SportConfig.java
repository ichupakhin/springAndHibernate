package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  com.luv2code.springcoredemo.common.Coach;

@Configuration
public class SportConfig {

    //@Bean instead of @Component is necessary for third party beans in order to get them into our App.
    //We didn't create this bean/class by ourselfs, so we can't write @Component over the class,
    // because the java file for the class is no there!
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();

    }

}
