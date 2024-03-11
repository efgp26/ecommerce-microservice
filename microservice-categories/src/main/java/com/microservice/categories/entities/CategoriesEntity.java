package com.microservice.categories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "categories_ecommerce")
public class CategoriesEntity {

    @Id
    private Long id;

    private String name;

    private List<Long> productsId;

}
