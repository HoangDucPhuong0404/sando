package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.services.dto.ColorDTO;
import org.springframework.stereotype.Component;

@Component
public class ColorMapper {

    public Color toColor(ColorDTO colorDTO) {
        return new Color()
                .setId(colorDTO.getId())
                .setTitle(colorDTO.getTitle());
    }

    public ColorDTO toColor(Color color) {
        return new ColorDTO()
                .setId(color.getId())
                .setTitle(color.getTitle());
    }
}
