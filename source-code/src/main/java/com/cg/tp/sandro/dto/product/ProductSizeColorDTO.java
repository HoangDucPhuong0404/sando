package com.cg.tp.sandro.dto.product;

import com.cg.tp.sandro.repositories.models.Color;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductSizeColorDTO {

    private SizeResult size;

    private Color color;

    private Short quantity;

    private BigDecimal price;

    private String uniqueStringId;
}
