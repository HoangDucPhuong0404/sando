package com.cg.tp.sandro.dto.color;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ColorParam {
    private Long id;
    private String title;
}
