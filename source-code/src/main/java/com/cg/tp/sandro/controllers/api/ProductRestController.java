<<<<<<< HEAD
package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.exception.ResourceNotFoundException;

import com.cg.tp.sandro.repositories.models.*;
import com.cg.tp.sandro.services.category.ICategoryService;
import com.cg.tp.sandro.services.color.IColorService;
import com.cg.tp.sandro.services.order.IOrderService;
import com.cg.tp.sandro.services.product.IProductService;
import com.cg.tp.sandro.services.size.ISizeService;
import com.cg.tp.sandro.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
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
=======
package com.cg.tp.sandro.controllers.api;//package com.cg.tp.sandro.controllers.api;
//
//import com.cg.tp.sandro.exception.ResourceNotFoundException;
//import com.cg.tp.sandro.repositorys.models.*;
//import com.cg.tp.sandro.services.category.ICategoryService;
//import com.cg.tp.sandro.services.color.IColorService;
//import com.cg.tp.sandro.services.order.IOrderService;
//import com.cg.tp.sandro.services.product.IProductService;
//import com.cg.tp.sandro.services.size.ISizeService;
//import com.cg.tp.sandro.utils.AppUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api/product")
//public class ProductRestController {
//
//    @Autowired
//    private AppUtils appUtils;
//
//    @Autowired
//    private IProductService productService;
//
//    @Autowired
//    private IColorService colorService;
//
//    @Autowired
//    private ISizeService sizeService;
//
//    @Autowired
//    private ICategoryService categoryService;
//
//    @Autowired
//    private IOrderService orderService;
//
//
//
//    @GetMapping("/order")
//    public ResponseEntity<?> getAllOrder(){
//        List<Order> orders = orderService.findAll();
//        return new ResponseEntity<>(orders,HttpStatus.OK);
//    }
//
//    @GetMapping("/category")
//    public ResponseEntity<?> getAllCategory(){
//        List<Category> categories = categoryService.findAll();
//        return new ResponseEntity<>(categories, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/size")
//    public ResponseEntity<?> getAllSize(){
//        List<Size> sizes = sizeService.findAll();
//        return new ResponseEntity<>(sizes, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/color")
//    public ResponseEntity<?> getAllColor(){
//        List<Color> colors = colorService.findAll();
//        return new ResponseEntity<>(colors, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<?> getAllProduct(){
//        List<Product> products = productService.findAll();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable Long id){
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()){
//            throw new ResourceNotFoundException("Invalid product Id");
>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9
//        }
//        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
//    }
//
////    @PostMapping("/create")
////    public ResponseEntity<?> doCreate(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){
////        if (bindingResult.hasErrors()){
////            return appUtils.mapErrorToResponse(bindingResult);
////        }
////        productDTO.setId(0L);
////
////        Product newProduct = productService.save(productDTO.toProduct());
////
////        return new ResponseEntity<>(newProduct.toProductDTO(), HttpStatus.CREATED);
////    }
//
////    @PutMapping("/update")
////    public ResponseEntity<?> doUpdate(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){
////        if (bindingResult.hasErrors()){
////            return appUtils.mapErrorToResponse(bindingResult);
////        }
////
////        Product updateProduct = productService.save(productDTO.toProduct());
////
////        return new ResponseEntity<>(updateProduct.toProductDTO(),HttpStatus.ACCEPTED);
////    }
////    @DeleteMapping("/delete/{id}")
////    public ResponseEntity<?> doDelete(@PathVariable Long id, @RequestBody ProductDTO productDTO){
////        Product deletedProduct = productService.deleteProductById(id);
////
////        return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
////    }
//}
