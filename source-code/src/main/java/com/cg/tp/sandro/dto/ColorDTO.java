package com.cg.tp.sandro.dto;

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

}
