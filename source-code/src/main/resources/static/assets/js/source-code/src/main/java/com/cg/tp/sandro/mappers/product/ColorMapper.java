package com.cg.tp.sandro.mappers.product;

import com.cg.tp.sandro.dto.color.ColorParam;
import com.cg.tp.sandro.dto.color.ColorResult;
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
