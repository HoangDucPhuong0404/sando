package com.cg.tp.sandro.services.color;

import com.cg.tp.sandro.dto.product.ColorParam;
import com.cg.tp.sandro.dto.product.ColorResult;
import com.cg.tp.sandro.repositories.ColorRepository;
import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.services.color.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements IColorService {

    @Autowired
    private ColorRepository colorRepository;

//    @Override
//    public List<Color> findAll() {
//        return colorRepository.findAll();
//    }
//
//    @Override
//    public Optional<Color> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Color save(Color color) {
//        return colorRepository.save(color);
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }

    @Override
    public Boolean existsByTitle(String title) {
        return colorRepository.existsByTitle(title);
    }

    @Override
    public List<ColorResult> findAll() {
        return null;
    }

    @Override
    public ColorResult create(ColorParam param) {
        return null;
    }
}
