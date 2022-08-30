package com.cg.team_project2.service.size;

import com.cg.team_project2.model.Size;
import com.cg.team_project2.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceimpl implements ISizeService{

    @Autowired
    private SizeRepository sizeRepository;


    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Optional<Size> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Size getById(Long id) {
        return null;
    }

    @Override
    public Size save(Size size) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
