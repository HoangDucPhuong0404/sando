package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.services.dto.SizeDTO;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper {

    public Size toSize(SizeDTO sizeDTO) {
        return new Size()
                .setId(sizeDTO.getId())
                .setSize(sizeDTO.getSize());
    }

    public SizeDTO toSize(Size size) {
        return new SizeDTO()
                .setId(size.getId())
                .setSize(size.getSize());
    }
}
