<<<<<<< HEAD
package com.cg.tp.sandro.services.order;


import com.cg.tp.sandro.repositories.OrderRepository;
import com.cg.tp.sandro.repositories.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceimp implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
=======
package com.cg.tp.sandro.services.order;//package com.cg.tp.sandro.services.order;
//
//import com.cg.team_project2.model.Order;
//import com.cg.tp.sandro.repositorys.OrderRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderServiceimp implements IOrderService{
//
//  //  @Autowired
//    private OrderRepository orderRepository;
//
//    @Override
//    public List<Order> findAll() {
//        return orderRepository.findAll();
//    }
//
//    @Override
//    public Optional<Order> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Order getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Order save(Order order) {
//        return null;
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//}
>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9
