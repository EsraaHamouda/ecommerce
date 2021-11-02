package com.ecommerce.dtos;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  ProductDto {
    private Long id;
    private String name;
    private String description;
    private String category;
}
