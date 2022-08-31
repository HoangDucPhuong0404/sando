package com.cg.tp.sandro.repositories.models;

import javax.persistence.*;

@Entity
@Table(name = "size")
public class Size {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size", nullable = false, length = 75)
    private String size;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}