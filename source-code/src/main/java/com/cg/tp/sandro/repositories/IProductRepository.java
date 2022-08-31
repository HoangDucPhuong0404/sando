package com.cg.tp.sandro.repositorys;

import com.cg.tp.sandro.dto.ProductParam;
import com.cg.tp.sandro.repositorys.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query("select new com.cg.tp.sandro.dto.ProductParam(" +
            "p.id," +
            "p.title," +
            "p.slug," +
            "p.content," +
            "p.summary," +
            "pro_cat.product.id," +
            "pro_cat.category.id," +
            "pro_cat.category.title," +
            "pro_cat.category.slug," +
            "pro_cat.category.content," +
            "pro_siz_col.color.id," +
            "pro_siz_col.color.title," +
            "pro_siz_col.size.id," +
            "pro_siz_col.size.size," +
            "pro_siz_col.price," +
            "pro_siz_col.quantity," +
            "pro_siz_col.uniqueStringId)" +
            "from Product p " +
            "join ProductCategory pro_cat on p.id = pro_cat.product.id " +
            "join ProductSizeColor pro_siz_col on p.id = pro_siz_col.product.id")
    List<ProductParam> getAllProductParams();


}
