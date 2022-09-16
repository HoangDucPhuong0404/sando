package com.cg.tp.sandro.services.order;

import com.cg.tp.sandro.dto.OrderResult;
import com.cg.tp.sandro.repositories.OrderRepository;
import com.cg.tp.sandro.repositories.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<OrderResult> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }


//    @Override
//    public Order save(Order order) {
//        return orderRepository.save(order);
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }

}
