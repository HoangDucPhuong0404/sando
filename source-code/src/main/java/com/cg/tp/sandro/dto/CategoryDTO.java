package com.cg.tp.sandro.dto;

import com.cg.tp.sandro.repositories.models.Category;
<<<<<<< HEAD
import lombok.*;
import lombok.experimental.Accessors;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CategoryDTO {

<<<<<<< HEAD
    private Long id;
    private Category parent;

    @NotNull(message = "please typing title field")
    @Size(max = 75)
    private String title;

    @NotNull(message = "Please typing slug field")
    @Size(max = 100)
    private String slug;
=======
    private String title;

    public Category toCategory(){
        return new Category()
                .setId(id)
                .setTitle(title);
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35

    }
}
