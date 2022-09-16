//package com.cg.tp.sandro.mappers.product;
//
//import com.cg.tp.sandro.dto.product.ProductParam;
//import com.cg.tp.sandro.dto.product.ProductResult;
//import com.cg.tp.sandro.dto.product.ProductSizeColorResult;
//import com.cg.tp.sandro.repositories.models.Product;
//import com.cg.tp.sandro.repositories.models.ProductSizeColor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class ProductListMapper {
//    @Autowired
//    ProductMapper productMapper;
//
//    public List<ProductResult> toDTOList(List<Product> products) {
//        return products.stream().map(productMapper::toDTO).collect(Collectors.toList());
//    }
//
//}
