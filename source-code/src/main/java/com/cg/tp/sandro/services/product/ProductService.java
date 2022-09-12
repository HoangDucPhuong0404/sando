package com.cg.tp.sandro.services.product;

import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.repositories.IProductRepository;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.mappers.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

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
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductResult> findAllProductDeletedIsFalse
            (Pageable pageable) {

        Page<Product> page = productRepository.findAllByDeletedIsFalse(pageable);
        return page.map(new Function<Product, ProductResult>() {
            @Override
            public ProductResult apply(Product product) {
                return productMapper.toDTO(product);
            }
        });

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public int countProductsDeletedFalse() {
        return productRepository.countProductsByDeletedIsFalse();
    }

    @Override
    public Page<ProductResult> findAll(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        return page.map(new Function<Product, ProductResult>() {
            @Override
            public ProductResult apply(Product product) {
                return productMapper.toDTO(product);
            }
        });
    }

}
