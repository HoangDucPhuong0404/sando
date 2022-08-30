package com.cg.tp.sandro.repositorys.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSizeColorId implements Serializable {
    private static final long serialVersionUID = -6747260200057963877L;
    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column(name = "sizeId", nullable = false)
    private Long sizeId;

    @Column(name = "colorId", nullable = false)
    private Long colorId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

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