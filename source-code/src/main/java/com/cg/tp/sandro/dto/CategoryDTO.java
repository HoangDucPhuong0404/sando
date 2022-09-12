package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    private String title;

    public Category toCategory(){
        return new Category()
                .setId(id)
                .setTitle(title);

    }
}
