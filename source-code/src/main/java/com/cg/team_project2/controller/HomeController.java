package com.cg.team_project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/hello");
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView showLogin(){
        return new ModelAndView("/login/login");
    }
}
