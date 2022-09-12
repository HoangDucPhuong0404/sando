package com.cg.tp.sandro.dto;


import com.cg.tp.sandro.repositories.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;


import java.time.Instant;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class NewProductParam {
        private String title;
       private MultipartFile mainImg;
       private MultipartFile images;
       private String slug;
       private String content;
       private Instant createAt;
    private List<ProductSizeColorParam> psclList;

    public Product toProduct(){
        return new Product()
                .setTitle(title)
                .setMainImgUrl(String.valueOf(mainImg))
                .setSlug(slug)
                .setContent(content)
                .setCreatedAt(createAt);

    }
}
