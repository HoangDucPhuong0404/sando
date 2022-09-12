package com.cg.tp.sandro.dto.product;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class SizeParam {
    private Long id;
    private String title;

}
