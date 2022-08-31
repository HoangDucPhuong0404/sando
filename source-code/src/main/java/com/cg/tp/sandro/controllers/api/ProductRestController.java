package com.cg.tp.sandro.controllers.api;

import com.cg.tp.sandro.services.category.ICategoryService;
import com.cg.tp.sandro.services.color.IColorService;
import com.cg.tp.sandro.services.order.IOrderService;
import com.cg.tp.sandro.services.product.IProductService;
import com.cg.tp.sandro.services.size.ISizeService;
import com.cg.tp.sandro.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
