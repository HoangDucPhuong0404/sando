package com.cg.tp.sandro.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class CreateProductParam {
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
