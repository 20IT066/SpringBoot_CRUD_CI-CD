package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "<h1>Hello, everyone, My Name is Parth Mangukiya from new t2.medium server and ID is 20it066 <br>Welome to spring CI/CD</h1>";
    }

}
