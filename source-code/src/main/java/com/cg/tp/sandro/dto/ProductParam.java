package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "createdAt")
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


    private BigDecimal price;
    private Short quantity;

    @NotNull(message = "Please choose file image")
    private MultipartFile file;

    public ProductParam(Long productId, String title, String slug, String mainImgUrl, String summary, Instant createdAt, Instant updatedAt, Instant publishedAt, String content,
                        Long categoryId, String categoryTitle, String categorySlug, String categoryContent,
                        Long sizeId, String size,
                        Long colorId, String colorTitle,
                        BigDecimal price, Short quantity,
                        String cloudId, String fileName, String fileFolder, String fileUrl, ProductSizeColor uniqueString) {
        this.productId = productId;
        this.title = title;
        this.slug = slug;
        this.mainImgUrl = mainImgUrl;
        this.summary = summary;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categorySlug = categorySlug;
        this.categoryContent = categoryContent;
        this.sizeId = sizeId;
        this.size = size;
        this.colorId = colorId;
        this.colorTitle = colorTitle;
        this.price = price;
        this.quantity = quantity;
        this.cloudId = cloudId;
        this.fileFolder = fileFolder;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.uniqueString = uniqueString;
    }
}
