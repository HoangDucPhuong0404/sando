package com.cg.tp.sandro.services.color;


import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.services.IGeneralService;

public interface IColorService extends IGeneralService<Color> {
    Boolean existsByTitle(String title);
}
