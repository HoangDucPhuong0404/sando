package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByDeletedIsFalse(Pageable pageable);

    int countProductsByDeletedIsFalse();

    @Modifying
    @Query(value = "UPDATE product p SET p.deleted = TRUE WHERE p.id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Long id);
}
