package com.microservice.products.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection  = "products_ecommerce")
public class ProductEntity
{

    private ObjectId id;
    private String name;
    private BigDecimal price;
    private String description;
    private String amount;
    private String image;
    private Long userId;
    private Integer stock;
    private Long categoriesId;
}
