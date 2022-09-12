package com.cg.tp.sandro.services.category;

import com.cg.tp.sandro.repositories.models.Category;
import com.cg.tp.sandro.services.IGeneralService;

public interface ICategoryService extends IGeneralService<Category> {
    Boolean exitsByTitle(String title);
}
