package com.cg.tp.sandro.services.order;

import com.cg.team_project2.model.Order;
import com.cg.tp.sandro.repositorys.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceimp implements IOrderService{

  //  @Autowired
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
