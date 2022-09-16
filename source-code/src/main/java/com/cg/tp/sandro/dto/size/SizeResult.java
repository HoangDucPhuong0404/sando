package com.cg.tp.sandro.dto.size;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SizeResult {
    private Long id;
    private String title;
    private String code;
}
