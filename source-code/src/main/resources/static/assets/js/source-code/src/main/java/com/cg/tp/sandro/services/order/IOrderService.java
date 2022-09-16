package com.cg.tp.sandro.services.order;


import com.cg.tp.sandro.dto.OrderResult;
import com.cg.tp.sandro.repositories.models.Order;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderResult> findAll(Pageable pageable);

    Optional<Order> findById(Long id);

}
