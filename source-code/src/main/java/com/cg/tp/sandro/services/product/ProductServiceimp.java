package com.cg.tp.sandro.services.product;


import com.cg.tp.sandro.dto.ProductDTO;
import com.cg.tp.sandro.repositories.ProductRepository;
import com.cg.tp.sandro.repositories.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceimp implements IProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {

    }




    @Override
    public List<ProductDTO> findAllProductDTODeletedFalse() {
        return null;
    }

//    @Override
//    public Page<Product> findAll(org.springframework.data.domain.Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public Page<Product> findAllDeletedIsFalse(org.springframework.data.domain.Pageable pageable) {
//        return productRepository.findAllByDeletedIsFalse((Pageable) PageRequest.of(1,10));
//    }
//
//    @Override
//    public Iterable<Product> findAllById(Long id) {
//        return null;
//    }

    @Override
    public Optional<ProductDTO> getProductDTObyId(Long id) {
        return null;
//        return Optional.ofNullable(productRepository.getProductDTObyId(id));
    }

    @Override
    public Product deleteProductById(Long id) {
        return productRepository.deleteProductById(id);
//        return productRepository.deleteProductById(id);
    }
}
