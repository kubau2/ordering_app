package com.dzejju.ordering_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/test")
    @ResponseBody
    public String getFoos(@RequestParam String id) {
        if (id.isEmpty()){
            return "No ID given";
        } else{
            return "ID: " + id;
        }
    }

}