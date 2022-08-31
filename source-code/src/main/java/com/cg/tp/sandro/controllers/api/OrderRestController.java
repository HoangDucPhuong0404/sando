package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.repositories.models.Order;
import com.cg.tp.sandro.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

    @Autowired
    private IOrderService orderService;


    @GetMapping("/")
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return new ResponseEntity<>(orderOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can not find product !", HttpStatus.NOT_FOUND);
    }


}
