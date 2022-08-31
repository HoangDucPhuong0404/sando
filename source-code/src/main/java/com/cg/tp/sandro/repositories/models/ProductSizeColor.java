package com.cg.tp.sandro.repositories.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "product_size_color")
public class ProductSizeColor {
    @EmbeddedId
    private ProductSizeColorId id;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @MapsId("sizeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sizeId", nullable = false)
    private Size size;

    @MapsId("colorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "colorId", nullable = false)
    private Color color;

    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @Column(name = "uniqueStringId")
    private String uniqueStringId;

    @OneToMany(mappedBy = "uniqueString")
    private Set<ProductMedia> productMedia = new LinkedHashSet<>();

}