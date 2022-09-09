package com.cg.tp.sandro.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class SizeDTO {

    private Long id;
    private String size;

}
