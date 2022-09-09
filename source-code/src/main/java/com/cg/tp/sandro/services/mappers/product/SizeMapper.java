package com.cg.tp.sandro.services.mappers.product;

import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.dto.product.SizeParam;
import com.cg.tp.sandro.dto.product.SizeResult;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper {

    public Size toModel(SizeParam param) {
        return new Size()
                .setId(param.getId())
                .setTitle(param.getSize());
        //TODO: XU LY CHYEUN DOI TITLE THANH CODE Small ->S setCode("S")
    }

    public SizeResult toDTO(Size size) {
        return new SizeResult()
                .setId(size.getId())
                .setTitle(size.getTitle())
                .setCode(size.getCode());

    }
}
