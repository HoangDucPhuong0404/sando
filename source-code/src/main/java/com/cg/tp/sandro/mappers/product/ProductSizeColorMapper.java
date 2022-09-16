package com.cg.tp.sandro.mappers.product;

import com.cg.tp.sandro.dto.color.ColorResult;
import com.cg.tp.sandro.dto.product.*;
import com.cg.tp.sandro.dto.size.SizeResult;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.repositories.models.ProductSizeColorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSizeColorMapper {
    @Autowired
    SizeMapper sizeMapper;
    @Autowired
    ColorMapper colorMapper;

    public ProductSizeColor toModel(long colorId, long sizeId, long productId) {
        return new ProductSizeColor()
                .setId(new ProductSizeColorId(colorId, sizeId, productId));
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
