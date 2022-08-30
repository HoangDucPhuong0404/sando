package com.cg.tp.sandro.repositorys.models;

import javax.persistence.*;

@Entity
@Table(name = "product_media")
public class ProductMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileFolder() {
        return fileFolder;
    }

    public void setFileFolder(String fileFolder) {
        this.fileFolder = fileFolder;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public ProductSizeColor getUniqueString() {
        return uniqueString;
    }

    public void setUniqueString(ProductSizeColor uniqueString) {
        this.uniqueString = uniqueString;
    }

}