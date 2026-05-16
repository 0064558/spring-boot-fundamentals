package com.luv2code.springboot.demo.mycoolapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
