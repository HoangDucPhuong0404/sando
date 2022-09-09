package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.repositories.models.ProductMedia;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.dto.ProductMediaDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMediaMapper {

    public ProductMedia toProductMedia(ProductMediaDTO productMediaDTO, ProductSizeColor productSizeColor) {
        return new ProductMedia()
                .setId(productMediaDTO.getId())
                .setFileName(productMediaDTO.getFileName())
                .setFileFolder(productMediaDTO.getFileFolder())
                .setFileUrl(productMediaDTO.getFileUrl())
                .setUniqueString(productSizeColor);
    }

    public ProductMediaDTO toProductMediaDTO(ProductMedia productMedia, ProductSizeColor productSizeColor) {
        return new ProductMediaDTO()
                .setId(productMedia.getId())
                .setFileName(productMedia.getFileName())
                .setFileFolder(productMedia.getFileFolder())
                .setFileUrl(productMedia.getFileUrl())
                .setUniqueString(productSizeColor);
    }
}
