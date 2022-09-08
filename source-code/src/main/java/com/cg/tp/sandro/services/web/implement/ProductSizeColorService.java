package com.cg.tp.sandro.services.web.implement;

import com.cg.tp.sandro.repositories.IProductSizeColorRepository;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.services.web.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductSizeColorService implements IGeneralService<ProductSizeColor> {

    @Autowired
    private IProductSizeColorRepository productSizeColorRepository;

    @Override
    public Iterable<ProductSizeColor> findAll() {
        return productSizeColorRepository.findAll();
    }

    @Override
    public Optional<ProductSizeColor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductSizeColor save(ProductSizeColor productSizeColor) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
