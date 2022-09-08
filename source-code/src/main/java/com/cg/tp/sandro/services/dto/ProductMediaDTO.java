package com.cg.tp.sandro.services.dto;

import com.cg.tp.sandro.repositories.models.ProductSizeColor;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ProductMediaDTO {

    private String id;
    private String fileFolder;
    private String fileName;
    private String fileUrl;
    private ProductSizeColor uniqueString;

}
