package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositorys.models.ProductSizeColor;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductParam {

    private Long id;

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

    private String isDelete;


    //product-media
    private String cloudId;
    private String fileFolder;
    private String fileName;
    private String fileUrl;
    private ProductSizeColor uniqueString;

    @NotNull(message = "Please choose file image")
    private MultipartFile file;

}
