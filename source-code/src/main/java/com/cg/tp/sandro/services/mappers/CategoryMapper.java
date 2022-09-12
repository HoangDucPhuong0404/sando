package com.cg.tp.sandro.services.mappers;

import com.cg.tp.sandro.dto.CategoryParam;
import com.cg.tp.sandro.dto.CategoryResult;
import com.cg.tp.sandro.repositories.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toModel(CategoryParam param) {
        return new Category();
//                .setId(param.getId())
//                .setTitle(param.getTitle())
//                .setSlug(param.getSlug())
//                .setContent(param.getContent())
//                .setParent(param.getParent());
    }

    public CategoryResult toDTO(Category category) {
        return new CategoryResult();
//                .setId(category.getId())
//                .setTitle(category.getTitle())
//                .setSlug(category.getSlug())
//                .setContent(category.getContent())
//                .setParent(category.getParent());
    }
}
