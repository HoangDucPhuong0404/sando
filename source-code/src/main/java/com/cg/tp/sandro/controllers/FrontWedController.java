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
public class FrontWedController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ModelAndView homeSandro(@PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView();
        Page<ProductResult> result = productService.findAll(pageable);
        System.out.println(result);
        modelAndView.setViewName("web/shoes");
        modelAndView.addObject("products", result);
        return modelAndView;
    }

}
