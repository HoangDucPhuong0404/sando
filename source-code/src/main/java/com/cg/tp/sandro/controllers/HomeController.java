package com.cg.tp.sandro.controllers;

import com.cg.tp.sandro.repositories.models.Order;
import com.cg.tp.sandro.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class HomeController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/product")
    public ModelAndView showProduct(){
        return new ModelAndView("admin/dashboard/product/product_list");
    }


    @GetMapping("/product/update")
    public ModelAndView showUpdate(){
        return new ModelAndView("admin/dashboard/product/updateProduct");
    }

    @GetMapping("/product/create")
    public ModelAndView showCreate(){
        return new ModelAndView("admin/dashboard/product/createProduct");
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(){
        return new ModelAndView("admin/dashboard/product/dashboard");
    }


    @GetMapping("/order")
    public ModelAndView showOrder(){
        return new ModelAndView("admin/dashboard/order/order_list");
    }

    @GetMapping("/order/{id}")
    public ModelAndView showUpdateOrder(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/dashboard/order/updateOrder");
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()){
                modelAndView.addObject("order", orderOptional);
        }
        else {
            modelAndView.addObject("order", new Order());
        }
        return modelAndView;
    }
//    @GetMapping("/user")
//    public ModelAndView showUser(){
//        return new ModelAndView("admin/dashboard/product/product_list");
//    }
}
