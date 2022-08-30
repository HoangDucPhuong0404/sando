package com.cg.team_project2.repository;

import com.cg.team_project2.model.Product;
import com.cg.team_project2.model.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query(value = "select p from Product p where p.deleted = false ")
    Page<Product> findAllByDeletedIsFalse(Pageable pageable) ;

    @Query(value = "select p from Product p where p.deleted = false ")
    List<Product> findAllByDeletedIsFalse() ;

//    @Query("SELECT NEW com.cg.team_project2.model.dto.ProductDTO (p.id, p.categories, p.sizes, p.colors, p.image, p.title, p.price, p.quantity, p.status, p.description) FROM Product AS p WHERE p.deleted = false ")
//    List<ProductDTO> findAllProductDTOdeletedIsFalse();
//
//    @Query("SELECT NEW com.cg.team_project2.model.dto.ProductDTO (p.id, p.categories, p.sizes, p.colors, p.image, p.title, p.price, p.quantity, p.status, p.description) FROM Product AS p WHERE p.id = ?1 ")
//    ProductDTO getProductDTObyId( Long id);

//    @Query(value = "update Product SET deleted = true where id = ?1", nativeQuery = true)
//    Product deleteProductById(Long id);
}
