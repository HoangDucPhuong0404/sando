package com.cg.tp.sandro.services.dto;

import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.ProductSizeColorId;
import com.cg.tp.sandro.repositories.models.Size;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductSizeColorDTO {

    private ProductSizeColorId id;

    private Product product;

    private Size size;

    private Color color;

    private Short quantity;

    private BigDecimal price;

    private String uniqueStringId;
}
