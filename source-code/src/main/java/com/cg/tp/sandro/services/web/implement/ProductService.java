package com.cg.tp.sandro.services.web.implement;

import com.cg.tp.sandro.repositories.ICategoryRepository;
import com.cg.tp.sandro.repositories.IProductCategoryRepository;
import com.cg.tp.sandro.repositories.IProductSizeColorRepository;
import com.cg.tp.sandro.repositories.models.ProductCategory;
import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import com.cg.tp.sandro.services.dto.ProductDTO;
import com.cg.tp.sandro.repositories.IProductRepository;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.dto.PageableResult;
import com.cg.tp.sandro.services.mappers.IModelMapper;
import com.cg.tp.sandro.services.mappers.PageableMapper;
import com.cg.tp.sandro.services.mappers.ProductMapper;
import com.cg.tp.sandro.services.web.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Autowired
    private IProductSizeColorRepository productSizeColorRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PageableMapper<Product, ProductDTO> pageableMapper;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
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
        productRepository.deleteById(id);
    }


    @Override
    public PageableResult<ProductDTO> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> pages = productRepository.findAll(pageable);
        return pageableMapper.toResult(pages, new IModelMapper<Product, ProductDTO>() {

            @Override
            public List<ProductDTO> toListDto(List<Product> products) {
                return products.stream().map(productMapper::toProductDTO).collect(Collectors.toList());
            }
        });

    }

}
