package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.dto.category.CategoryResult;
import com.cg.tp.sandro.dto.color.ColorParam;
import com.cg.tp.sandro.dto.color.ColorResult;
import com.cg.tp.sandro.dto.product.UpdateProductParam;
import com.cg.tp.sandro.dto.product.*;
import com.cg.tp.sandro.dto.size.SizeParam;
import com.cg.tp.sandro.dto.size.SizeResult;
import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.categories.ICategoryService;
import com.cg.tp.sandro.services.color.IColorService;
import com.cg.tp.sandro.services.order.IOrderService;
import com.cg.tp.sandro.services.product.IProductService;
import com.cg.tp.sandro.services.size.ISizeService;
import com.cg.tp.sandro.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
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

    @GetMapping("/sdf")
    public Page<ProductResult> homeSandroo(@PageableDefault(size = 10) Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("")
    public ResponseEntity<?> showAllProducts(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ProductResult> paged = productService.findAll(pageable);
        return new ResponseEntity<>(paged, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            return new ResponseEntity<>(productOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreateProduct(@Validated @RequestBody CreateProductParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        ProductResult newProduct = productService.create(param);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody UpdateProductParam updateProductParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Optional<Product> productOptional = productService.findById(updateProductParam.getProductId());


        if (productOptional.isPresent()) {
            ProductResult updatedProduct = productService.update(updateProductParam);
           // Product updatedProduct = productService.save(productOptional.get());
            return new ResponseEntity<>(updatedProduct,HttpStatus.OK);// new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't update product", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            productService.deleteProduct(id);
           // productService.save(productOptional.get());
            return new ResponseEntity<>("Deleted product success !", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find out product", HttpStatus.NOT_FOUND);
    }

//    CATEGORY rest ------->

    @PostMapping("/category/create")
    public ResponseEntity<?> doCreateCategory(@RequestBody Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exitsTitle = categoryService.exitsByTitle(category.getTitle());
        if (exitsTitle) {
            return new ResponseEntity<>("Title category has arrived !", HttpStatus.BAD_REQUEST);
        }
        category.setId(0L);
        Category newCategory = categoryService.save(category);
        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> showAllCategory() {
        List<CategoryResult> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    -----------> Size

    @PostMapping("/size/create")
    public ResponseEntity<?> doCreateSize(@RequestBody SizeParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exits = sizeService.existsBySize(param.getTitle());
        if (exits) {
            return new ResponseEntity<>("Title category has arrived !", HttpStatus.BAD_REQUEST);
        }
        param.setId(0L);
        SizeResult newSize = sizeService.create(param);
        return new ResponseEntity<>(newSize, HttpStatus.OK);
    }

    @GetMapping("/sizes")
    public ResponseEntity<?> showAllSize() {
        List<SizeResult> sizes = sizeService.findAll();
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }


    @GetMapping("/colors")
    public ResponseEntity<?> showAllColor() {
        List<ColorResult> colors = colorService.findAll();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }


    @PostMapping("/color/create")
    public ResponseEntity<?> doCreateColor(@RequestBody ColorParam colorParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exits = colorService.existsByTitle(colorParam.getTitle());
        if (exits) {
            return new ResponseEntity<>("Title color has arrived !", HttpStatus.BAD_REQUEST);
        }
        colorParam.setId(0L);
        ColorResult newColor = colorService.create(colorParam);
        return new ResponseEntity<>(newColor, HttpStatus.OK);
    }


    @GetMapping("/count")
    public ResponseEntity<?> countProduct() {
        int countedProduct = productService.countProductsDeletedFalse();
        return new ResponseEntity<>(countedProduct, HttpStatus.OK);
    }


}
