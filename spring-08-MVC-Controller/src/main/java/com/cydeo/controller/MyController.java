package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
@RequestMapping("/feedback")
    public String myCtrl(){

        return "feedback/feedback.html";
    }
    @RequestMapping("/lolo")
    public String myLolo(){

    return "login.html";
    }
}
