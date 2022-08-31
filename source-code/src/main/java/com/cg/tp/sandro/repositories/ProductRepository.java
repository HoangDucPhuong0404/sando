<<<<<<< HEAD:source-code/src/main/java/com/cg/tp/sandro/repositories/ProductRepository.java
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
=======
package com.cg.tp.sandro.repositorys;

import com.cg.tp.sandro.repositorys.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9:source-code/src/main/java/com/cg/tp/sandro/repositorys/ProductRepository.java
}
