package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.dto.PageableResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageableMapper<Model, DTO> {

    public PageableResult<DTO> toResult(Page<Model> page, IModelMapper<Model, DTO> modelMapper) {
        List<DTO> dtoList = modelMapper.toListDto(page.getContent());
        return new PageableResult<DTO>().setContent(dtoList)
                .setPageNo(page.getNumber())
                .setPageSize(page.getSize())
                .setTotalElements(page.getTotalElements())
                .setTotalPages(page.getTotalPages())
                .setLast(page.isLast());
    }

}
