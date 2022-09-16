package com.cg.tp.sandro.services.product;


import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    Product save(Product product);

    void remove(Long id);


    Page<ProductResult> findAllProductDeletedIsFalse(Pageable pageable);


    void deleteProduct(Long id);

    int countProductsDeletedFalse();

    // tan_dev
    Page<ProductResult> findAll(Pageable pageable);

    // tan_dev
    ProductResult findProductBySlug(String slug);
}
