package com.cg.team_project2.service.product;

import com.cg.team_project2.model.Product;
import com.cg.team_project2.model.dto.ProductDTO;
import com.cg.team_project2.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {

   List<ProductDTO> findAllProductDTOdeletedFalse();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllDeletedIsFalse(Pageable pageable);

    Iterable<Product> findAllById(Long id);

    Optional<ProductDTO> getProductDTObyId(Long id);

    Product deleteProductById(Long id);
}
