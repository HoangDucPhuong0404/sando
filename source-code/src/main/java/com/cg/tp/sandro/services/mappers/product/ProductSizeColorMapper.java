package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.dto.product.*;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSizeColorMapper {
    @Autowired
    SizeMapper sizeMapper;
    @Autowired
    ColorMapper colorMapper;

    public ProductSizeColor toModel(SizeParam size, ColorParam color, ProductParam product) {
        return null;
    }

    public ProductSizeColorResult toDTO(ProductSizeColor productSizeColor) {
        ColorResult color = colorMapper.toDTO(productSizeColor.getColor());
        SizeResult size = sizeMapper.toDTO(productSizeColor.getSize());

        return new ProductSizeColorResult()
                .setPrice(productSizeColor.getPrice())
                .setQuantity(productSizeColor.getQuantity())
                .setSize(size)
                .setColor(color)
                .setUniqueStringId(productSizeColor.getUniqueStringId());
    }

}
