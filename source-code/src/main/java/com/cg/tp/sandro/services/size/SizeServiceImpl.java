package com.cg.tp.sandro.services.size;


import com.cg.tp.sandro.dto.product.SizeParam;
import com.cg.tp.sandro.dto.product.SizeResult;
import com.cg.tp.sandro.repositories.SizeRepository;
import com.cg.tp.sandro.repositories.models.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceImpl implements ISizeService {

    @Autowired
    private SizeRepository sizeRepository;


    @Override
    public List<SizeResult> findAll() {
        //return sizeRepository.findAll();
        return null;
    }

    @Override
    public Optional<Size> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public SizeResult create(SizeParam size) {
        // return sizeRepository.save(size);
        return null;
    }


    @Override
    public boolean existsBySize(String title) {
        return sizeRepository.existsByTitle(title);
    }
}
