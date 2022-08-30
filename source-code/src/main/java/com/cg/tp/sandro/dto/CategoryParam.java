package com.cg.tp.sandro.dto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CategoryParam {

    private Long categoryId;

    @NotNull
    @Size(max = 75)
    private String categoryTitle;

    @NotNull
    @Size(max = 100)
    private String slug;

    @Lob
    @Column(name = "content")
    private String content;
}
