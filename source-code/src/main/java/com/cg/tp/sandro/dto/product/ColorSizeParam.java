package com.cg.tp.sandro.dto.product;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ColorSizeParam {
    private Long colorId;
    private Long sizeId;
    private int quantity;
    private BigDecimal price;
}
