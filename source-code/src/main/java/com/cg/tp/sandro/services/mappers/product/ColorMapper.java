package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.dto.ColorDTO;
import com.cg.tp.sandro.dto.product.ColorResult;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    public Color toModel(ColorDTO colorDTO) {
        return new Color()
                .setId(colorDTO.getId())
                .setTitle(colorDTO.getTitle());
    }

    public ColorResult toDTO(Color color) {
        return new ColorResult()
                .setId(color.getId())
                .setTitle(color.getTitle())
                .setCode(color.getCode());

    }
}
