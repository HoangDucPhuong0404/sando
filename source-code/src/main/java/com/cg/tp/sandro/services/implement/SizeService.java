package com.cg.tp.sandro.services.implement;

import com.cg.tp.sandro.repositorys.ISizeRepository;
import com.cg.tp.sandro.repositorys.models.Size;
import com.cg.tp.sandro.services.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService implements ISizeService {

    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public List<Size> findAll() {
        return null;
    }

    @Override
    public Optional<Size> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Size save(Size size) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
