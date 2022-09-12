package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.dto.product.ProductParam;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.dto.product.ProductSizeColorResult;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    @Autowired
    private ProductSizeColorMapper productSizeColorMapper;

    public Product toModel(ProductParam param) {
        return null;//new Product()
//                .setId(param.getId())
//                .setTitle(param.getTitle())
//                .setSlug(param.getSlug())
//                .setMainImgUrl(param.getMainImgUrl())
//                .setContent(param.getContent());
    }


    public ProductResult toDTO(Product product) {

        List<ProductSizeColorResult> productSizeColorList = new ArrayList<>();

        for (ProductSizeColor productSizeColor : product.getProductSizeColors()) {
            ProductSizeColorResult productSizeColorDTo = productSizeColorMapper.toDTO(productSizeColor);
            productSizeColorList.add(productSizeColorDTo);
        }
//        List<ProductSizeColorResult> productSizeColorList = product.getProductSizeColors().stream().map(productSizeColorMapper::toDTO).collect(Collectors.toList());
        return new ProductResult()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setSlug(product.getSlug())
                .setMainImgUrl(product.getMainImgUrl())
                .setContent(product.getContent())
                .setProductSizeColorList(productSizeColorList);
    }

}
