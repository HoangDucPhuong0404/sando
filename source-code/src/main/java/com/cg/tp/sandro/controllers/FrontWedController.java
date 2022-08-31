package com.cg.tp.sandro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class FrontWedController {

    @GetMapping()
    public ModelAndView homeSandro() {
        return new ModelAndView("web/shoes");
    }
}
