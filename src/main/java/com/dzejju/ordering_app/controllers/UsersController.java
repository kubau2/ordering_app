package com.dzejju.ordering_app.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam String Name, @RequestParam String Surname, @RequestParam String Address) {
        if (!Name.trim().isEmpty() && !Surname.trim().isEmpty() && !Address.trim().isEmpty()){

            return "User added";
        } else{
            return "Please fill in neccessary data"; //tutaj daj exceptiony
            //throw new
        }
    }
}
