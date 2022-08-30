package com.cg.tp.sandro.repositorys.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public ProductSizeColorId getId() {
        return id;
    }

    public void setId(ProductSizeColorId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUniqueStringId() {
        return uniqueStringId;
    }

    public void setUniqueStringId(String uniqueStringId) {
        this.uniqueStringId = uniqueStringId;
    }

    public Set<ProductMedia> getProductMedia() {
        return productMedia;
    }

    public void setProductMedia(Set<ProductMedia> productMedia) {
        this.productMedia = productMedia;
    }

}