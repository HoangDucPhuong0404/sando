package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.dto.product.ProductSizeColorDTO;
import lombok.*;
import lombok.experimental.Accessors;

<<<<<<< HEAD
import java.util.List;
=======
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.ProductMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.time.Instant;
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductDTO {

    private Long id;

    private String title;

<<<<<<< HEAD
    private String slug;

    private String mainImgUrl;

    private String summary;

=======
    private String  mainImgUrl;

    private String slug;

    private Instant createAt;



    private BigDecimal price;

    private Short quantity;

    private Long category;

    private Long color;

    private Long size;

    private String summary;

>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35
    private String content;

//    private Set<ProductCategory> productCategories = new LinkedHashSet<>();

    private List<ProductSizeColorDTO> productSizeColors;


    private String status;


    public Product toProduct(){
        return new Product()
                .setId(0L)
                .setTitle(title)
                .setMainImgUrl(mainImgUrl)
                .setSlug(slug)
                .setCreatedAt(createAt)
                .setSummary(summary)
                .setContent(content);

    }
//    public Product toProduct(){
//        return new Product()
//                .setId(id)
//                .setTitle(title)
//                .setSlug(slug)
//                .setMainImgUrl(mainImgUrl.getId())
//
//    }


}
