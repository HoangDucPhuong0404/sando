package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.dto.NewProductParam;
import com.cg.tp.sandro.dto.ProductDTO;
import com.cg.tp.sandro.mappers.ProductMapper;
import com.cg.tp.sandro.repositories.SizeRepository;
import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.repositories.models.Color;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.repositories.models.Size;
import com.cg.tp.sandro.services.category.ICategoryService;
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



    @GetMapping("")
    public ResponseEntity<?> showAllProducts(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)Pageable pageable){
        Page<Product> productPage = productService.findAllPageProduct(pageable);

        if (productPage.isEmpty()){
            return new ResponseEntity<>("List product is empty",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            return new ResponseEntity<>(productOptional,HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreateProduct(@Validated @RequestBody NewProductParam productParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Product newProduct = productService.save(productParam.toProduct());
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody NewProductParam newProductParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Product transferProduct = newProductParam.toProduct();
        Optional<Product> productOptional = productService.findById(transferProduct.getId());
        if (productOptional.isPresent()){
            Product updatedProduct = productService.save(productOptional.get());
            return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't update product", HttpStatus.NOT_FOUND);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Long id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            productOptional.get().setDeleted(true);
            productService.save(productOptional.get());
            return new ResponseEntity<>("Deleted product success !", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find out product", HttpStatus.NOT_FOUND);
    }

//    CATEGORY rest ------->

    @PostMapping("/category/create")
    public ResponseEntity<?> doCreateCategory(@RequestBody Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exitsTitle = categoryService.exitsByTitle(category.getTitle());
        if (exitsTitle){
            return new ResponseEntity<>("Title category has arrived !", HttpStatus.BAD_REQUEST);
        }
        category.setId(0L);
        Category newCategory = categoryService.save(category);
        return new ResponseEntity<>(newCategory,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<?> showAllCategory(){
        List<Category>categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>("Empty category !", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

//    -----------> Size

    @PostMapping("/size/create")
    public ResponseEntity<?> doCreateSize(@RequestBody Size size, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exits = sizeService.existBySize(size.getSize());
        if (exits){
            return new ResponseEntity<>("Title category has arrived !", HttpStatus.BAD_REQUEST);
        }
        size.setId(0L);
        Size newSize = sizeService.save(size);
        return new ResponseEntity<>(newSize,HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<?> showAllSize(){
        List<Size>sizes = sizeService.findAll();
        if (sizes.isEmpty()){
            return new ResponseEntity<>("Empty Size !", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sizes,HttpStatus.OK);
    }


    @GetMapping("/color")
    public ResponseEntity<?> showAllColor(){
        List<Color>colors = colorService.findAll();
        if (colors.isEmpty()){
            return new ResponseEntity<>("Empty color !", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(colors,HttpStatus.OK);
    }


    @PostMapping("/color/create")
    public ResponseEntity<?> doCreateColor(@RequestBody Color color, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Boolean exits = colorService.existsByTitle(color.getTitle());
        if (exits){
            return new ResponseEntity<>("Title color has arrived !", HttpStatus.BAD_REQUEST);
        }
        color.setId(0L);
        Color newColor = colorService.save(color);
        return new ResponseEntity<>(newColor,HttpStatus.OK);
    }



    @GetMapping("/count")
    public ResponseEntity<?> countProduct(){
        int countedProduct = productService.countProductDeletedFalse();
        return new ResponseEntity<>(countedProduct,HttpStatus.OK);
    }






}
