package com.cg.tp.sandro.controllers;

import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class FrontWebController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ModelAndView homeSandro(@PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        Page<ProductResult> result = productService.findAll(pageable);
        modelAndView.setViewName("web/nshoes");
        modelAndView.addObject("products", result);
        return modelAndView;
    }

    @GetMapping("/item")
    public ModelAndView itemSandro(){
        return new ModelAndView("web/item");
    }

    @GetMapping("/profile")
    public ModelAndView profileSandro(){
        return new ModelAndView("web/profile");
    }

    @GetMapping("/address")
    public ModelAndView addressSandro(){
        return new ModelAndView("web/address_ship");
    }

    @GetMapping("/cart")
    public ModelAndView cartSandro(){
        return new ModelAndView("web/cart");
    }

    @GetMapping("/payment")
    public ModelAndView paymentSandro(){
        return new ModelAndView("web/payment");
    }

    @GetMapping("/login")
    public ModelAndView loginSandro(){
        return new ModelAndView("web/form_login");
    }
}
