package com.cg.team_project2.model;

import com.cg.team_project2.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Accessors(chain = true)
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category", joinColumns = {@JoinColumn(name = "productId")},
    inverseJoinColumns = {@JoinColumn(name = "categoryId")} )
    private Set<Category> categories = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_size", joinColumns = {@JoinColumn(name = "productId")},
    inverseJoinColumns = {@JoinColumn(name = "sizeId")})
    private Set<Size> sizes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_color", joinColumns = {@JoinColumn(name = "productId")},
    inverseJoinColumns = {@JoinColumn(name = "colorId")})
    private Set<Color> colors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "image_id",nullable = false)
    private Image image;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    Set<Cart_item> cartItems = new LinkedHashSet<>();

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;


//    public ProductDTO toProductDTO(){
//        return new ProductDTO()
//                .setId(id)
//                .setCategory_id(categories)
//                .setSize_id(sizes)
//                .setColor((Color) colors)
//                .setImage(image)
//                .setTitle(title)
//                .setPrice(price)
//                .setQuantity(quantity)
//                .setStatus(status)
//                .setDescription(description);
//    }
}
