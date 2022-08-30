package com.cg.team_project2.controller.api;

import com.cg.team_project2.model.Order;
import com.cg.team_project2.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

    @Autowired
    private IOrderService orderService;


    @GetMapping("/")
    public ResponseEntity<?> getAllOrders(){
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id){
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()){
            return new ResponseEntity<>(orderOptional,HttpStatus.OK);
        }
        return new ResponseEntity<>("Can not find product !", HttpStatus.NOT_FOUND);
    }


}
