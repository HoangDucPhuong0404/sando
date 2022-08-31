package com.cg.tp.sandro.controllers.apiFront;

import com.cg.tp.sandro.dto.ProductParam;
import com.cg.tp.sandro.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/web/")
public class FrontProductRestController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping("products/")
    public ResponseEntity<?> getAllProducts() {

        List<ProductParam> productParams = productRepository.getAllProductParams();

        if(productParams.isEmpty()) {
            return new ResponseEntity<>("List product is empty", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productParams, HttpStatus.OK);
    }
}
