package com.cg.team_project2.model.dto;

import com.cg.team_project2.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProductDTO {
    private Long id;


    private Set<Category> category_id;



    private Long size_id;




    private Long  color_id;


    private Long image_id;

    private String title;




    private BigDecimal price;


    private int quantity;


    private String status;


    private String description;

//    public Product toProduct(){
//        return new Product()
//                .setId(id)
//                .setCategories(category_id)
//                .setSizes(size_id)
//                .setColors( color_id)
//                .setImage(image_id)
//                .setTitle(title)
//                .setPrice(price)
//                .setQuantity(quantity)
//                .setStatus(status)
//                .setDescription(description);
//    }
}
