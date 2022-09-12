package com.cg.tp.sandro.services.order;


import com.cg.tp.sandro.repositories.models.Order;
import com.cg.tp.sandro.services.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService extends IGeneralService<Order> {
        Page<Order> findAllPage(Pageable pageable);


}
