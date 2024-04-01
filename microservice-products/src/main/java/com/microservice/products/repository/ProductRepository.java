package com.microservice.products.repository;

import com.microservice.products.entities.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Long> {

    @Query("{ 'id' : ?0 }")
    ProductEntity findByIdObject(ObjectId id);


    void deleteById(ObjectId id);
}
