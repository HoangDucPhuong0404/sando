package com.cg.tp.sandro.repositories.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Category parent;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "slug", nullable = false, length = 100)
    private String slug;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<ProductCategory> productCategories = new LinkedHashSet<>();


}