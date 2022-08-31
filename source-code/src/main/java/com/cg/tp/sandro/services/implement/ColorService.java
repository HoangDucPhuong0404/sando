package com.cg.tp.sandro.services.implement;

import com.cg.tp.sandro.repositorys.IColorRepository;
import com.cg.tp.sandro.repositorys.models.Color;
import com.cg.tp.sandro.services.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService implements IColorService {

    @Autowired
    private IColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        return null;
    }

    @Override
    public Optional<Color> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Color save(Color color) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
