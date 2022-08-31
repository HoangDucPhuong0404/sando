package com.cg.tp.sandro.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private Long id;


    private String title;


    private String slug;


    private String mainImgUrl;


    private String summary;


    private boolean deleted;

    private String content;


}
