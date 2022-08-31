package com.cg.tp.sandro.repositories.models;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "size")
public class Size {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size", nullable = false, length = 75)
    private String size;
}