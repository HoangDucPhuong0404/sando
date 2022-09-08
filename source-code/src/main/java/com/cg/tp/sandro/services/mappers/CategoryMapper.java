package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.services.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryDTO categoryDTO) {
        return new Category()
                .setId(categoryDTO.getId())
                .setTitle(categoryDTO.getTitle())
                .setSlug(categoryDTO.getSlug())
                .setContent(categoryDTO.getContent())
                .setParent(categoryDTO.getParent());
    }

    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO()
                .setId(category.getId())
                .setTitle(category.getTitle())
                .setSlug(category.getSlug())
                .setContent(category.getContent())
                .setParent(category.getParent());
    }
}
