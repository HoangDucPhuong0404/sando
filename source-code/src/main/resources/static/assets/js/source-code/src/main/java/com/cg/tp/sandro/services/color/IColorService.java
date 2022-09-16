package com.cg.tp.sandro.services.color;


import com.cg.tp.sandro.dto.color.ColorParam;
import com.cg.tp.sandro.dto.color.ColorResult;

import java.util.List;

public interface IColorService {
    Boolean existsByTitle(String title);

    List<ColorResult> findAll();

    ColorResult create(ColorParam param);
}
