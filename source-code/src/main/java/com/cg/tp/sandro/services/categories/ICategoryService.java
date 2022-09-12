package com.cg.tp.sandro.services.categories;

import com.cg.tp.sandro.dto.CategoryResult;
import com.cg.tp.sandro.repositories.models.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    List<CategoryResult> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    void remove(Long id);

    Boolean exitsByTitle(String title);
}
