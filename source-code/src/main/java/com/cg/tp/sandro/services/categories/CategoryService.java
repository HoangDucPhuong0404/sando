package com.cg.tp.sandro.services.categories;

import com.cg.tp.sandro.dto.CategoryResult;
import com.cg.tp.sandro.repositories.CategoryRepository;
import com.cg.tp.sandro.repositories.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResult> findAll() {
        return null;
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
