package com.cg.tp.sandro.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ColorResult {
    private Long id;
    private String title;
    private String code;
}
