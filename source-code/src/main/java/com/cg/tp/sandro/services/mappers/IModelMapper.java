package com.cg.tp.sandro.services.mappers;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IModelMapper<Model, DTO> {
    List<DTO> toListDto(List<Model> modelList);
}
