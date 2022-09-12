package com.cg.tp.sandro.services.web.implement;

import com.cg.tp.sandro.repositories.ICategoryRepository;
import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.services.web.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CateGoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Boolean exitsByTitle(String title) {
        return categoryRepository.existsByTitle(title);
    }
}
