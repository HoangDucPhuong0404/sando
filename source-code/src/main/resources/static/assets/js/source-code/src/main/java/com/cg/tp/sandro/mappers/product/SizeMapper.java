package com.cg.tp.sandro.mappers.product;

import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.dto.size.SizeParam;
import com.cg.tp.sandro.dto.size.SizeResult;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper {

    public Size toModel(SizeParam param) {
        return new Size()
                .setId(param.getId())
                .setTitle(param.getTitle());
    }

    public SizeResult toDTO(Size size) {
        return new SizeResult()
                .setId(size.getId())
                .setTitle(size.getTitle())
                .setCode(size.getCode());

    }
}
