package com.cg.tp.sandro.repositories.models;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Embeddable
public class ProductSizeColorId implements Serializable {
    private static final long serialVersionUID = -6747260200057963877L;
    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column(name = "sizeId", nullable = false)
    private Long sizeId;

    @Column(name = "colorId", nullable = false)
    private Long colorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductSizeColorId entity = (ProductSizeColorId) o;
        return Objects.equals(this.sizeId, entity.sizeId) &&
                Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.colorId, entity.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeId, productId, colorId);
    }

}