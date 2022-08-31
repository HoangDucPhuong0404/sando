package com.cg.tp.sandro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    private Long parentId;

    private Long productId;

    private String productName;

    private String title;

    private String slug;

    private String content;
}
