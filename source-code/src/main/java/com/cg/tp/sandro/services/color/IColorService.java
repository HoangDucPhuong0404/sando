package com.cg.tp.sandro.services.color;


import com.cg.tp.sandro.dto.product.ColorParam;
import com.cg.tp.sandro.dto.product.ColorResult;
import com.cg.tp.sandro.repositories.models.Color;

import java.util.List;

public interface IColorService {
    Boolean existsByTitle(String title);

    List<ColorResult> findAll();

    ColorResult create(ColorParam param);
}
