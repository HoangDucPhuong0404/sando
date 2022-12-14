package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.dto.OrderResult;
import com.cg.tp.sandro.repositories.models.Order;
import com.cg.tp.sandro.services.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    private IOrderService orderService;


    @GetMapping("")
    public ResponseEntity<?> findAll(Pageable pageable) {
        List<OrderResult> orders = orderService.findAll(pageable);
        if (orders.isEmpty()) {
            return new ResponseEntity<>("Empty Order", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<?> getAllOrders(@PageableDefault(size = 10,sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
//
//        Page<Order> orders = orderService.findAllPage(pageable);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.findById(id);
        if (orderOptional.isPresent()) {
            return new ResponseEntity<>(orderOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can not find product !", HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/revenue")
//    public ResponseEntity<?> totalRevenue(){
//
//    }


}
