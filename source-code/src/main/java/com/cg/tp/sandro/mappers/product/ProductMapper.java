package com.cg.tp.sandro.mappers.product;

import com.cg.tp.sandro.dto.product.UpdateProductParam;
import com.cg.tp.sandro.dto.product.CreateProductParam;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.dto.product.ProductSizeColorResult;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper {

    @Autowired
    private ProductSizeColorMapper productSizeColorMapper;

    public Product toModel(CreateProductParam param) {
        return new Product()
                .setTitle(param.getTitle())
                .setSlug(param.getSlug())
                .setCreatedAt(Instant.now())
                .setContent(param.getContent());
    }

    public Product toModel(UpdateProductParam param) {
        return null;
    }


    public ProductResult toDTO(Product product) {

        List<ProductSizeColorResult> productSizeColorListResult = new ArrayList<>();
        Set<ProductSizeColor> productSizeColors = product.getProductSizeColors();
        if (productSizeColors != null)
            for (ProductSizeColor productSizeColor : productSizeColors) {
                ProductSizeColorResult productSizeColorDTo = productSizeColorMapper.toDTO(productSizeColor);
                productSizeColorListResult.add(productSizeColorDTo);
            }
//        List<ProductSizeColorResult> productSizeColorList = product.getProductSizeColors().stream().map(productSizeColorMapper::toDTO).collect(Collectors.toList());
        return new ProductResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setSlug(product.getSlug())
                .setMainImgUrl(product.getMainImgUrl())
                .setContent(product.getContent())
                .setProductSizeColorList(productSizeColorListResult);
    }

}
