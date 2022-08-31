package com.cg.tp.sandro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    private Long productId;

    private String productName;

    private Long orderId;

    private Float price;

    private Short quantity;

    private String content;
}
