package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.repositories.models.ProductCategory;
import com.cg.tp.sandro.repositories.models.ProductCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {

    @Query("select pro_cat " +
            "from ProductCategory pro_cat " +
            "where pro_cat.product.id =:id")
    Set<ProductCategory> getAllProductCategoryByIdPro(@Param("id") Long id);

    @Query("select cat " +
            "from ProductCategory pro_cat " +
            "join Category cat on pro_cat.category.id = cat.id " +
            "where pro_cat.product.id =:id")
    Set<Category> getAllCategoryByIdPro(@Param("id") Long id);
}
