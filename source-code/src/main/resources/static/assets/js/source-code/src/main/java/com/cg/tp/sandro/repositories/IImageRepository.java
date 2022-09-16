package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.ProductMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<ProductMedia,Long> {
}
