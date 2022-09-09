package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.ProductCategoryId;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductCategoryDTO {

    private ProductCategoryId id;
    private Product product;
    private Category category;

}
