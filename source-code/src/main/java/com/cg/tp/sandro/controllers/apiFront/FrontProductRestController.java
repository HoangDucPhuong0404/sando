package com.cg.tp.sandro.controllers.apiFront;

import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;
import com.cg.tp.sandro.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<?> findAll(@PageableDefault(size = 10)
                                             Pageable pageable) {
        Page<ProductResult> paged = productService.findAll(pageable);
        return new ResponseEntity<>(paged, HttpStatus.OK);
    }


}
