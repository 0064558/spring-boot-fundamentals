package com.luv2code.springboot.demo.mycoolapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach Name: "
                + coachName + ", "
                + "Team Name: "
                + teamName;
    }

    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String sayWorkout() {
        return "Corra uma maratona de 5KM!";
    }

    @GetMapping("/fortune")
    public String sayFortune() {
        return "Today is your luck day!";
    }
}
