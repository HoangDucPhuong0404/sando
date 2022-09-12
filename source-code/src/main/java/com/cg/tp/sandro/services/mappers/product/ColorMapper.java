package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.dto.product.ColorParam;
import com.cg.tp.sandro.dto.product.ColorResult;
import com.cg.tp.sandro.repositories.models.Color;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    public Color toModel(ColorParam param) {
        return new Color()
                .setId(param.getId())
                .setTitle(param.getTitle());
    }

    public ColorResult toDTO(Color color) {
        return new ColorResult()
                .setId(color.getId())
                .setTitle(color.getTitle())
                .setCode(color.getCode());

    }
}
