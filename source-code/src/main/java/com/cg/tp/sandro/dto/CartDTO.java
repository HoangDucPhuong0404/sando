package com.cg.tp.sandro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;

    private Long productId;

    private String productName;

    private Long cartId;

    private Float price;

    private Short quantity;

    private String content;
}
