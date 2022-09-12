package com.cg.tp.sandro.repositories.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
=======
import com.cg.tp.sandro.dto.NewProductParam;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "slug")
    private String slug;

    @Column(name = "mainImgUrl")
    private String mainImgUrl;

    @Column(name = "summary")
    private String summary;

    @Column(name = "createdAt")
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Column(name = "deleted")
    private boolean deleted;

    @Lob
    @Column(name = "content")
    private String content;

<<<<<<< HEAD
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<ProductSizeColor> productSizeColors;
=======
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<ProductSizeColor> productSizeColors = new LinkedHashSet<>();


    public NewProductParam toNewProductParam(){
        return new NewProductParam()
                .setTitle(title)
                .setContent(content)
                .setSlug(slug)
                .setCreateAt(createdAt);
    }
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35
}