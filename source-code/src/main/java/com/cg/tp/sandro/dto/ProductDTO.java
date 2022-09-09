package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.dto.product.ProductSizeColorDTO;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductDTO {

    private Long id;

    private String title;

    private String slug;

    private String mainImgUrl;

    private String summary;

    private String content;

//    private Set<ProductCategory> productCategories = new LinkedHashSet<>();

    private List<ProductSizeColorDTO> productSizeColors;

}
