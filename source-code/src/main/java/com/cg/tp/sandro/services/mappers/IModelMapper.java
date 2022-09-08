package com.cg.tp.sandro.services.mappers;

import java.util.List;

public interface IModelMapper<Model, DTO> {
    List<DTO> toListDto(List<Model> modelList);
}
