package com.cg.tp.sandro.services.web;

import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.dto.PageableResult;
import com.cg.tp.sandro.dto.product.ProductResult;

public interface IProductService extends IGeneralService<Product> {

    PageableResult<ProductResult> findAll(Integer pageNo, Integer pageSize);

}
