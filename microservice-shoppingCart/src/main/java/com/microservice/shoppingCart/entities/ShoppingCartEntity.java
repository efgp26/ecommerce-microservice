package com.microservice.shoppingCart.entities;

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
@Document(collection = "shopping_cart_ecommerce")
public class ShoppingCartEntity {

    @Id
    private Long id;

    private List<Long> productsId;

    private Long userId;

}
