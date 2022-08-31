package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ProductParam {

    private Long productId;

    @NotNull(message = "Title is not null")
    @Size(max = 75)
    private String title;

    @NotNull(message = "Slug is not null")
    @Size(max = 100)
    private String slug;

    private String mainImgUrl;
    private String summary;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @NotNull(message = "Content is not null")
    private String content;

    // category
    private Long categoryId;

    @NotNull
    @Size(max = 75)
    private String categoryTitle;

    @NotNull
    @Size(max = 100)
    private String categorySlug;

    @Lob
    @Column(name = "content")
    private String categoryContent;

    // color
    private Long colorId;

    @NotNull
    @Size(max = 100)
    private String colorTitle;

    // size
    private Long sizeId;

    @NotNull
    @Size(max = 75)
    private String size;


    //product-media
    private String cloudId;
    private String fileFolder;
    private String fileName;
    private String fileUrl;
    private ProductSizeColor uniqueString;

    @NotNull(message = "Please choose file image")
    private MultipartFile file;

}
