package com.cg.tp.sandro.services.size;


import com.cg.tp.sandro.dto.size.SizeParam;
import com.cg.tp.sandro.dto.size.SizeResult;
import com.cg.tp.sandro.repositories.SizeRepository;
import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.mappers.product.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SizeServiceImpl implements ISizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private SizeMapper sizeMapper;
    @Override
    public List<SizeResult> findAll() {
        //return sizeRepository.findAll();
        return sizeRepository.findAll().stream().map(sizeMapper::toDTO).collect(Collectors.toList());
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
