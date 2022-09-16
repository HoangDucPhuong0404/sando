package com.cg.tp.sandro.dto.product;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductResult {

    private Long id;

    private String title;

    private String slug;

    private String mainImgUrl;

    private String summary;

    private String content;

    private List<ProductSizeColorResult> productSizeColorList;

}
