package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.repositories.models.ProductSizeColorId;
import com.cg.tp.sandro.repositories.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IProductSizeColorRepository extends JpaRepository<ProductSizeColor, ProductSizeColorId> {

    @Query("select pro_siz_col " +
            "from ProductSizeColor pro_siz_col " +
            "where pro_siz_col.product.id =:id")
    Set<ProductSizeColor> getAllProductSizeColorByIdPro(@Param("id") Long id);

    @Query("select siz from ProductSizeColor pro_siz_col " +
            "join Size siz on pro_siz_col.size.id = siz.id " +
            "where pro_siz_col.product.id =: id ")
    Iterable<Size> getAllSizeByIdPro(@Param("id") Long id);

    @Query("select col from ProductSizeColor pro_siz_col " +
            "join Color col on pro_siz_col.size.id = col.id " +
            "where pro_siz_col.product.id =: id ")
    Iterable<Color> getAllColorByIdPro(@Param("id") Long id);
}
