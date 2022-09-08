package com.cg.tp.sandro.services.dto;

import com.cg.tp.sandro.repositories.models.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

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

    private Set<ProductCategory> productCategories = new LinkedHashSet<>();

    private Set<ProductSizeColorDTO> productSizeColors = new LinkedHashSet<>();

    private BigDecimal price;

    private Short quantity;





//    // category
//    private Long categoryId;
//    private String categoryTitle;
//    private String categorySlug;
//    private String categoryContent;
//
//    // color
//    private Long colorId;
//    private String colorTitle;
//
//    // size
//    private Long sizeId;
//    private String size;
//
//
//    //product-media
//    private String cloudId;
//    private String fileFolder;
//    private String fileName;
//    private String fileUrl;
//    private ProductSizeColor uniqueString;
//


}
