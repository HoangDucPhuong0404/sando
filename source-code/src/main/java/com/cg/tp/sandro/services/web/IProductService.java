package com.cg.tp.sandro.services.web;

import com.cg.tp.sandro.services.dto.ProductDTO;
import com.cg.tp.sandro.repositories.models.Product;
import com.cg.tp.sandro.services.dto.PageableResult;

public interface IProductService extends IGeneralService<Product> {

    PageableResult<ProductDTO> findAll(Integer pageNo, Integer pageSize);

}
