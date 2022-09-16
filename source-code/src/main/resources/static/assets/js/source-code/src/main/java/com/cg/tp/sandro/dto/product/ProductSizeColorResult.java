package com.cg.tp.sandro.dto.product;

import com.cg.tp.sandro.dto.color.ColorResult;
import com.cg.tp.sandro.dto.size.SizeResult;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProductSizeColorResult {

    private SizeResult size;

    private ColorResult color;

    private Short quantity;

    private BigDecimal price;

    private String uniqueStringId;
}
