package com.cg.tp.sandro.dto.product;

import com.cg.tp.sandro.dto.product.ColorSizeParam;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Accessors(chain = true)
public class UpdateProductParam {
    private Long productId;
    private String title;
    private String slug;
    private String content;
    // category
    private Long categoryId;


    @NotNull(message = "Please choose file image")
    private MultipartFile mainImage;

    List<ColorSizeParam> colorSizeList;

}
