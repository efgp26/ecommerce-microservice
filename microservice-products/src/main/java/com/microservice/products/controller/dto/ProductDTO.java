package com.microservice.products.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private ObjectId id;
    private String name;
    private BigDecimal price;
    private String description;
    private String amount;
    private String image;
    private Long userId;
    private Long categoriesId;
    private Integer stock;
}
