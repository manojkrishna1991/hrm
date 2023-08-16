package com.example.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hrm.model.Employee;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Hello hello, Employee employee) {
        hello.setName("manoj");
        return "index";
    }
}
