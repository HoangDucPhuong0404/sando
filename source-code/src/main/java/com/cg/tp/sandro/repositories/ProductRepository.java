package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Query("SELECT NEW com.cg.tp.sandro.repositories.models.Product(p.id,p.title, p.slug, p.mainImgUrl,p.summary, p.content)from Product p where p.deleted = false ")
//    List<Product> findAllProductDeletedIsFalse();

    List<Product> findAllByDeletedIsFalse();

    @Modifying
    @Query(value = "UPDATE product p SET p.deleted = TRUE where p.id = :id", nativeQuery = true)
    Product deleteProductById(@Param("id")Long id);
}
