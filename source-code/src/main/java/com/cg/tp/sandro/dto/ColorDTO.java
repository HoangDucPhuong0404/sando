package com.cg.tp.sandro.dto;

<<<<<<< HEAD
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
public class ColorDTO {

    private Long id;

    @NotNull(message = "Please typing title field")
    @Size(max= 75)
    private String title;

=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ColorDTO {
    private Long id;

    private String size;
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35
}
