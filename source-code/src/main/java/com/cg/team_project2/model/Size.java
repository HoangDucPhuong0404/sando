package com.cg.team_project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sizes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_size", joinColumns = {@JoinColumn(name = "sizeId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")})
    private Set<Product> products = new HashSet<>();
}
