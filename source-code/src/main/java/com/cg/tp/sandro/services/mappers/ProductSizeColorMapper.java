package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.services.dto.ProductSizeColorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductSizeColorMapper {

    public ProductSizeColor toProductSizeColor(ProductSizeColorDTO productSizeColorDTO, Size size, Color color, Product product) {
        return new ProductSizeColor()
                .setId(productSizeColorDTO.getId())
                .setPrice(productSizeColorDTO.getPrice())
                .setQuantity(productSizeColorDTO.getQuantity())
                .setSize(size)
                .setColor(color)
                .setProduct(product)
                .setUniqueStringId(productSizeColorDTO.getUniqueStringId());
    }

    public ProductSizeColorDTO toProductSizeColorDTO(ProductSizeColor productSizeColor, Size size, Color color, Product product) {
        return new ProductSizeColorDTO()
                .setId(productSizeColor.getId())
                .setPrice(productSizeColor.getPrice())
                .setQuantity(productSizeColor.getQuantity())
                .setSize(size)
                .setColor(color)
                .setProduct(product)
                .setUniqueStringId(productSizeColor.getUniqueStringId());
    }
}
