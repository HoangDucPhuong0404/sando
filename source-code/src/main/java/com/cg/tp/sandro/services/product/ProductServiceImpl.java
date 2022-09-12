package com.cg.tp.sandro.services.product;

import com.cg.tp.sandro.repositories.ProductRepository;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }


    @Override
    public List<Product> findAllProductDeletedIsFalse() {
        return productRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Page<Product> findAllPageProduct(Pageable pageable) {
        return productRepository.findAllDeletedFalse(pageable);
    }

    @Override
    public void deleteProduct(Long id) {
         productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> countProductDeletedIsFalse() {
        return productRepository.countProductsByDeletedIsFalse();
    }

    @Override
    public int countProductDeletedFalse() {
        return productRepository.countProductDeletedFalse();
    }
}
