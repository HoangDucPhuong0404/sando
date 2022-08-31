package com.cg.tp.sandro.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SizeParam {

    private Long id;

    @NotNull
    @Size(max = 75)
    private String size;
}
