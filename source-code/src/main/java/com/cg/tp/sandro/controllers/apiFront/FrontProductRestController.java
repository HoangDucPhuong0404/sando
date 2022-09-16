package com.cg.tp.sandro.controllers.apiFront;


import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.product.IProductService;
import com.cg.tp.sandro.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/products")
public class FrontProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("/{slug}")
    public ResponseEntity<?> findProductBySlug(@RequestParam String slug) {
        ProductResult productResult = productService.findProductBySlug(slug);
        System.out.println(productResult);
        return new ResponseEntity<>(productResult, HttpStatus.OK);
    }

}
