package com.cg.tp.sandro.controllers.apiFront;

import com.cg.tp.sandro.repositories.IProductSizeColorRepository;
import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.web.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class FrontProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSizeColorRepository productSizeColorRepository;

    @GetMapping("/products")
    public PageableResult<ProductResult> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                                 @RequestParam(defaultValue = "5") Integer pageSize) {
        return productService.findAll(pageNo, pageSize);
    }

//    @GetMapping("/products")
//    public PageableResult<ProductDTO> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
//                                              @RequestParam(defaultValue = "5") Integer pageSize) {
//        Product p = productService.findById(1L).get();
//        Iterable<Product> product = productService.findAll();
//
//        System.out.println(product);
//
//        product.
//        return productService.findAll(pageNo, pageSize);
//    }


}
