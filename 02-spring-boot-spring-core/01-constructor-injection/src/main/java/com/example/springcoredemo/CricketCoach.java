package com.example.springcoredemo;

import org.springframework.stereotype.Component;

@Component // marks the class as a Spring Bean for dependency injection
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowmling for 15 minutes!!!";
    }
}
