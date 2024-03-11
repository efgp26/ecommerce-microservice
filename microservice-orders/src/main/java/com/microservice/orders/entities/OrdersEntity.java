package com.microservice.orders.entities;

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
@Document(collection = "orders_ecommerce")
public class OrdersEntity {

    @Id
    private Long id;

    private Boolean stade;

    private List<Long> productsId;

    private Long userId;

}
