package com.microservice.products.persistence.impl;

import com.microservice.products.entities.ProductEntity;
import com.microservice.products.persistence.IProductDAO;
import com.microservice.products.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class productDAOImpl implements IProductDAO {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductEntity> findByIdObject(ObjectId id) {
        return Optional.ofNullable(productRepository.findByIdObject(id));
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll() != null ? productRepository.findAll() : null;
    }

    @Override
    public void save(ProductEntity user) {
        productRepository.save(user);
    }

    @Override
    public void deleteById(ObjectId id) {
        productRepository.deleteById(id);
    }
}
