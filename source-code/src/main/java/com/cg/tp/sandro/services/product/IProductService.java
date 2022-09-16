package com.cg.tp.sandro.services.product;


import com.cg.tp.sandro.dto.product.UpdateProductParam;
import com.cg.tp.sandro.dto.product.CreateProductParam;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    void remove(Long id);
    Page<ProductResult> findAllProductDeletedIsFalse(Pageable pageable);

    void deleteProduct(Long id);

    int countProductsDeletedFalse();

    Page<ProductResult> findAll(Pageable pageable);

    ProductResult create(CreateProductParam param);

    ProductResult update(UpdateProductParam updateProductParam);
    ProductResult findProductBySlug(String slug);
}
