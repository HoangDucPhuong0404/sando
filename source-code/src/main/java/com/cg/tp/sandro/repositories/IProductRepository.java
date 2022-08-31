package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

}
