package com.cg.tp.sandro.services.product;

import com.cg.tp.sandro.dto.product.ColorSizeParam;
import com.cg.tp.sandro.dto.product.CreateProductParam;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.dto.product.UpdateProductParam;
import com.cg.tp.sandro.mappers.product.ProductMapper;
import com.cg.tp.sandro.mappers.product.ProductSizeColorMapper;
import com.cg.tp.sandro.repositories.ColorRepository;
import com.cg.tp.sandro.repositories.IProductRepository;
import com.cg.tp.sandro.repositories.IProductSizeColorRepository;
import com.cg.tp.sandro.repositories.SizeRepository;
import com.cg.tp.sandro.repositories.models.*;
import com.cg.tp.sandro.services.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IProductSizeColorRepository productSizeColorRepository;

    @Autowired
    private ColorRepository colorRepository;


    @Autowired
    private ProductMapper productMapper;


    @Autowired
    private ProductSizeColorMapper productSizeColorMapper;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    protected IImageService iImageService;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductResult create(CreateProductParam param) {
        Product product = productRepository.save(productMapper.toModel(param));
        List<ColorSizeParam> colorSizeList = param.getColorSizeList();
        if (colorSizeList != null)
            for (ColorSizeParam colorSize : colorSizeList) {
                Color color = colorRepository.findById(colorSize.getColorId()).get();
                Size size = sizeRepository.findById(colorSize.getSizeId()).get();
                ProductSizeColor productSizeColor = productSizeColorMapper.toModel(colorSize.getColorId(), colorSize.getSizeId(), product.getId());
                productSizeColor.setUniqueStringId(product.getId() + "_" + color.getCode() + "_" + size.getCode());
                productSizeColorRepository.save(productSizeColor);
            }
        //xu ly upload MainImage trong param
        return productMapper.toDTO(product);
    }

    @Override
    public ProductResult update(UpdateProductParam updateProductParam) {
        Product product = productRepository.save(productMapper.toModel(updateProductParam));
        List<ColorSizeParam> colorSizeParamList = updateProductParam.getColorSizeList();
        for (ColorSizeParam colorSizeParam : colorSizeParamList) {
            Color color = colorRepository.findById(colorSizeParam.getColorId()).get();
            Size size = sizeRepository.findById(colorSizeParam.getSizeId()).get();

            ProductSizeColor productSizeColor = productSizeColorMapper.toModel(colorSizeParam.getColorId(), colorSizeParam.getSizeId(), product.getId());
            productSizeColor.setUniqueStringId(product.getId() + "_" + color.getCode() + "_" + size.getCode());
        }
        ProductMedia productMedia = new ProductMedia();
        productMedia.setFileName(updateProductParam.getMainImage().getOriginalFilename());
        iImageService.save(productMedia);

        product.setMainImgUrl(String.valueOf(productMedia));
        productRepository.save(product);

        ProductResult productResult = productMapper.toDTO(product);
//        productResult.setMainImgUrl(String.valueOf(productMedia));
//         ProductResult productResult = new ProductResult();
//        productResult.setMainImgUrl(String.valueOf(updateProductParam.getMainImage()));
        return productResult;
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }


    @Override
    public Page<ProductResult> findAllProductDeletedIsFalse
            (Pageable pageable) {

        Page<Product> page = productRepository.findAllByDeletedIsFalse(pageable);
        return page.map(productMapper::toDTO);
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
        return page.map(productMapper::toDTO);
    }

    @Override
    public ProductResult findProductBySlug(String slug) {
        Optional<Product> product = productRepository.findProductBySlug(slug);
        ProductResult productResult = productMapper.toDTO(product.get());
        return productResult;
    }



}
