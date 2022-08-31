package com.cg.tp.sandro.repositories.models;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "product_media")
public class ProductMedia {
    @Id
    @Column(name = "cloud_id", nullable = false)
    private String id;

    @Column(name = "file_folder")
    private String fileFolder;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_url", length = 500)
    private String fileUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uniqueStringId", nullable = false, referencedColumnName = "uniqueStringId")
    private ProductSizeColor uniqueString;

}