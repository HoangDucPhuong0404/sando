package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.Category;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CategoryDTO {

    private Long id;
    private Category parent;

    @NotNull(message = "please typing title field")
    @Size(max = 75)
    private String title;

    @NotNull(message = "Please typing slug field")
    @Size(max = 100)
    private String slug;

    private String content;
}
