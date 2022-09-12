package com.cg.tp.sandro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductSizeColorParam {
    private Long colorId;

    private Long productId;

    private Long sizeId;

    private BigDecimal price;

    private Integer quantity;



}
