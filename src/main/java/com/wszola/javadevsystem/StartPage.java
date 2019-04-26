package com.wszola.javadevsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class StartPage {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World " + LocalDateTime.now();
    }

}
