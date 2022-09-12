package com.cg.tp.sandro.services.web;

import com.cg.tp.sandro.repositories.models.Category;
<<<<<<< HEAD:source-code/src/main/java/com/cg/tp/sandro/services/web/ICategoryService.java

public interface ICategoryService extends IGeneralService<Category>{
=======
import com.cg.tp.sandro.services.IGeneralService;

public interface ICategoryService extends IGeneralService<Category> {
    Boolean exitsByTitle(String title);
>>>>>>> 4b23b420a98b5d92f03fea98f665b0d41c1fcd35:source-code/src/main/java/com/cg/tp/sandro/services/category/ICategoryService.java
}
