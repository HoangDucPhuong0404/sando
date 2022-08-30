package com.cg.team_project2.controller.api;

import com.cg.team_project2.exception.ResourceNotFoundException;
import com.cg.team_project2.model.*;
import com.cg.team_project2.model.dto.ProductDTO;
import com.cg.team_project2.service.category.ICategoryService;
import com.cg.team_project2.service.color.IColorService;
import com.cg.team_project2.service.order.IOrderService;
import com.cg.team_project2.service.product.IProductService;
import com.cg.team_project2.service.size.ISizeService;
import com.cg.team_project2.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private AppUtils appUtils;

    @Autowired
    private IProductService productService;

    @Autowired
    private IColorService colorService;

    @Autowired
    private ISizeService sizeService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IOrderService orderService;



    @GetMapping("/order")
    public ResponseEntity<?> getAllOrder(){
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory(){
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/size")
    public ResponseEntity<?> getAllSize(){
        List<Size> sizes = sizeService.findAll();
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }


    @GetMapping("/color")
    public ResponseEntity<?> getAllColor(){
        List<Color> colors = colorService.findAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            throw new ResourceNotFoundException("Invalid product Id");
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> doCreate(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return appUtils.mapErrorToResponse(bindingResult);
//        }
//        productDTO.setId(0L);
//
//        Product newProduct = productService.save(productDTO.toProduct());
//
//        return new ResponseEntity<>(newProduct.toProductDTO(), HttpStatus.CREATED);
//    }

//    @PutMapping("/update")
//    public ResponseEntity<?> doUpdate(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return appUtils.mapErrorToResponse(bindingResult);
//        }
//
//        Product updateProduct = productService.save(productDTO.toProduct());
//
//        return new ResponseEntity<>(updateProduct.toProductDTO(),HttpStatus.ACCEPTED);
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> doDelete(@PathVariable Long id, @RequestBody ProductDTO productDTO){
//        Product deletedProduct = productService.deleteProductById(id);
//
//        return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
//    }
}
