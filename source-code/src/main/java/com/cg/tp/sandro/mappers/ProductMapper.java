package com.cg.tp.sandro.mappers;

import com.cg.tp.sandro.dto.ProductParam;
import com.cg.tp.sandro.repositorys.models.*;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductParam productParam) {
        return new Product()
                .setId(productParam.getProductId())
                .setTitle(productParam.getTitle())
                .setSlug(productParam.getSlug())
                .setMainImgUrl(productParam.getMainImgUrl())
                .setSummary(productParam.getSummary())
                .setCreatedAt(productParam.getCreatedAt())
                .setPublishedAt(productParam.getPublishedAt())
                .setUpdatedAt(productParam.getUpdatedAt())
                .setContent(productParam.getContent());
    }

    public Category toCategory(ProductParam productParam) {
        return new Category()
                .setId(productParam.getProductId())
                .setTitle(productParam.getCategoryTitle())
                .setSlug(productParam.getCategorySlug())
                .setContent(productParam.getContent());
    }

    public Color toColor(ProductParam productParam) {
        return new Color()
                .setId(productParam.getColorId())
                .setTitle(productParam.getColorTitle());
    }

    public Size toSize(ProductParam productParam) {
        return new Size()
                .setId(productParam.getSizeId())
                .setSize(productParam.getSize());
    }

    public ProductMedia toProductMedia(ProductParam productParam) {
        return new ProductMedia()
                .setId(productParam.getCloudId())
                .setFileName(productParam.getFileName())
                .setFileFolder(productParam.getFileFolder())
                .setFileUrl(productParam.getFileUrl())
                .setUniqueString(productParam.getUniqueString());
    }

}
