package com.cg.tp.sandro.mapper;

import com.cg.tp.sandro.dto.ProductDTO;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
public Product toProduct(ProductDTO productDTO){
    Product product = new Product();
    product.setTitle(productDTO.getTitle());
    product.setSlug(productDTO.getTitle());
    product.setMainImgUrl(productDTO.getMainImgUrl());
    product.setSummary(productDTO.getSummary());
    product.setContent(productDTO.getContent());
    return product;
}





}
