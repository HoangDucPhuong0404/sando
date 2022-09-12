package com.cg.tp.sandro.controllers;

import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.web.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class FrontWedController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ModelAndView homeSandro() {
      return new ModelAndView("web/shoes");
    }

//    @GetMapping()
//    public ModelAndView homeSandro(@RequestParam(defaultValue = "0") Integer pageNo,
//                                   @RequestParam(defaultValue = "5") Integer pageSize) {
//        ModelAndView modelAndView = new ModelAndView();
//        PageableResult<ProductResult> productResultPageableResult = productService.findAll(pageNo, pageSize);
//        modelAndView.setViewName("web/shoes");
//        modelAndView.addObject("products", productResultPageableResult);
//        return modelAndView;
//    }

}
