package com.microservice.products.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "products_ecommerce")
public class ProductEntity
{
    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    private String description;
    private String amount;
    private String image;
    private Long userId;
    private Long categoriesId;
}
