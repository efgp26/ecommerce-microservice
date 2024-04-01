package com.microservice.products.services;

import com.microservice.products.entities.ProductEntity;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<ProductEntity> findByIdObject(ObjectId id);
    List<ProductEntity> findAll();
    void save(ProductEntity user);
    void deleteById(ObjectId id);
}
