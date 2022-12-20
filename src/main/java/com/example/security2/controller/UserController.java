package com.example.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String admin(){
        return "Admin sayfasi";
    }

    @GetMapping("/index")
    public String index(){
        return "Index sayfasina hosgeldiniz";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "Deshboard sayfasina hosgeldiniz";
    }
}
