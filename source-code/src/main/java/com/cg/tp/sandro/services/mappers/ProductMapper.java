package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.repositories.models.*;
import com.cg.tp.sandro.services.dto.ProductCategoryDTO;
import com.cg.tp.sandro.services.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductMapper {

    public Product toProduct(ProductDTO productDTO) {
        return new Product()
                .setId(productDTO.getId())
                .setTitle(productDTO.getTitle())
                .setSlug(productDTO.getSlug())
                .setMainImgUrl(productDTO.getMainImgUrl())
                .setContent(productDTO.getContent());
    }

//    public ProductDTO toProductDTO(Product product, Set<ProductCategory> productCategories, Set<ProductSizeColor> productSizeColors) {
//        return new ProductDTO()
//                .setId(product.getId())
//                .setTitle(product.getTitle())
//                .setSlug(product.getSlug())
//                .setContent(product.getContent())
//                .setProductCategories(productCategories)
//                .setProductSizeColors(productSizeColors);
//    }

    public ProductDTO toProductDTO(Product product) {
        ProductSizeColor[] prs = (ProductSizeColor[]) product.getProductSizeColors().toArray();
        for (ProductSizeColor p : prs) {
            p.
        }
        return new ProductDTO()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setSlug(product.getSlug())
                .setMainImgUrl(product.getMainImgUrl())
                .setContent(product.getContent())
                .setProductSizeColors(product.getProductSizeColors());
    }

}
