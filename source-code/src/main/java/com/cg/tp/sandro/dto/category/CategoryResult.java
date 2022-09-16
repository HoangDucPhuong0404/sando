package com.cg.tp.sandro.dto.category;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CategoryResult {
    private long id;
    private String slug;
    private String title;
}
