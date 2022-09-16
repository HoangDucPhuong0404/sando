package com.cg.tp.sandro.mappers;

import com.cg.tp.sandro.repositories.models.ProductCategory;
import com.cg.tp.sandro.dto.ProductCategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {

    public ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO) {
        return new ProductCategory()
                .setProduct(productCategoryDTO.getProduct())
                .setCategory(productCategoryDTO.getCategory());
    }

    public ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
        return new ProductCategoryDTO()
                .setProduct(productCategory.getProduct())
                .setCategory(productCategory.getCategory());
    }
}
