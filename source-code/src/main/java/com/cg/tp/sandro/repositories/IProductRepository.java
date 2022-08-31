package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.dto.ProductParam;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query("select new com.cg.tp.sandro.dto.ProductParam(" +
            "pro.id," +
            "pro.title," +
            "pro.slug," +
            "pro.summary," +
            "pro.content," +
            "pro.mainImgUrl," +
            "pro.createdAt," +
            "pro.updatedAt," +
            "pro.publishedAt, " +
            "pro_cat.category.id," +
            "pro_cat.category.title," +
            "pro_cat.category.slug," +
            "pro_cat.category.content," +
            "pro_siz_col.size.id," +
            "pro_siz_col.size.size," +
            "pro_siz_col.color.id," +
            "pro_siz_col.color.title," +
            "pro_siz_col.price," +
            "pro_siz_col.quantity," +
            "pro_med.id," +
            "pro_med.fileName," +
            "pro_med.fileFolder, " +
            "pro_med.fileUrl," +
            "pro_med.uniqueString" +
            ")" +
            "from Product pro " +
            "join ProductCategory pro_cat on pro.id = pro_cat.product.id " +
            "join ProductSizeColor pro_siz_col on pro.id = pro_siz_col.product.id " +
            "join ProductMedia pro_med on pro_siz_col.uniqueStringId = pro_med.uniqueString"
    )
    List<ProductParam> getAllProductParams();
}
