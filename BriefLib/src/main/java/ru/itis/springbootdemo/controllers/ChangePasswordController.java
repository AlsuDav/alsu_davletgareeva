package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangePasswordController {
    @GetMapping("/changePassword")
    public String getChange(){
        return "changepassword";
    }
}
