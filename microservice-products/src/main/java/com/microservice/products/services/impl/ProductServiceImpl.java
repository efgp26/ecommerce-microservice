package com.microservice.products.services.impl;

import com.microservice.products.entities.ProductEntity;
import com.microservice.products.persistence.IProductDAO;
import com.microservice.products.services.IProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDAO productDAO;


    @Override
    public Optional<ProductEntity> findByIdObject(ObjectId id) {
        return productDAO.findByIdObject(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productDAO.findAll() != null ? productDAO.findAll() : null;
    }

    @Override
    public void save(ProductEntity user) {
        productDAO.save(user);
    }

    @Override
    public void deleteById(ObjectId id) {
        productDAO.deleteById(id);
    }
}
