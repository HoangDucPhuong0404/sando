package com.cg.tp.sandro.repositorys;

import com.cg.tp.sandro.repositorys.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


}
