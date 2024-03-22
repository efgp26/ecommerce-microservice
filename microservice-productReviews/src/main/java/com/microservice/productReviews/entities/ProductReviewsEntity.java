package com.microservice.productReviews.entities;

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
@Document(collection = "product_reviews_ecommerce")
public class ProductReviewsEntity {

    @Id
    private Long id;

    private String comments;

    private Long userId;
}
