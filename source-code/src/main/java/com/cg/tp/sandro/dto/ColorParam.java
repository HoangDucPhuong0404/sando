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
public class ColorParam {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String title;
}
