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

    @GetMapping("/profile")
    public ModelAndView profileSandro() {
        return new ModelAndView("wed/profile");
    }

    @GetMapping("/cart")
    public ModelAndView cartSandro() {
        return new ModelAndView("web/cart");
    }

    @GetMapping("/address")
    public ModelAndView addressSandro() {
        return new ModelAndView("web/address_ship");
    }

    @GetMapping("/item")
    public ModelAndView itemSandro() {
        return  new ModelAndView("web/item");
    }

    @GetMapping("/payment")
    public ModelAndView paymentSandro() {
        return new ModelAndView("/web/payment");
    }

    @GetMapping("/login")
    public ModelAndView loginSandro() {
        return new ModelAndView("/wed/form_login");
    }
}
