package com.cg.tp.sandro.services.product;


import com.cg.tp.sandro.dto.ProductDTO;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {

   List<ProductDTO> findAllProductDTODeletedFalse();

//    Page<Product> findAll(Pageable pageable);
//
//    Page<Product> findAllDeletedIsFalse(Pageable pageable);
//
//    Iterable<Product> findAllById(Long id);

    Optional<ProductDTO> getProductDTObyId(Long id);

    Product deleteProductById(Long id);
}
