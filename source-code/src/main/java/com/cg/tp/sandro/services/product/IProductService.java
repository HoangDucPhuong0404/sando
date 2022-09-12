package com.cg.tp.sandro.services.product;


import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findAllProductDeletedIsFalse();

    Page<Product> findAllPageProduct(Pageable pageable);

    void deleteProduct(Long id);

    List<Product> countProductDeletedIsFalse();

    int countProductDeletedFalse();
}
