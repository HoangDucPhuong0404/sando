package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query( "SELECT p from Product p WHERE p.deleted = false ")
    Page<Product> findAllDeletedFalse(Pageable pageable);

    List<Product> findAllByDeletedIsFalse();

    @Query("select count(p) from Product p WHERE p.deleted = false ")
    List<Product> countProductsByDeletedIsFalse();

    @Query("select count(p) from Product p WHERE p.deleted = false ")
    int countProductDeletedFalse();


    @Modifying
    @Query(value = "UPDATE product p SET p.deleted = TRUE WHERE p.id = :id", nativeQuery = true)
    void deleteProduct(@Param("id") Long id);
}
