package com.cg.tp.sandro.controllers.apiFront;

import com.cg.tp.sandro.repositories.IProductSizeColorRepository;
import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.web.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class FrontProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                     @RequestParam(defaultValue = "5") Integer pageSize) {
        PageableResult<ProductResult> productResultPageableResult = productService.findAll(pageNo, pageSize);

        return new ResponseEntity<>(productResultPageableResult, HttpStatus.OK);
    }


}
