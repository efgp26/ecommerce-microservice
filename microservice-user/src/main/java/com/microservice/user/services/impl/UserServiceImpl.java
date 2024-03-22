package com.microservice.user.services.impl;

import com.microservice.user.entities.UserEntity;
import com.microservice.user.persistence.IUserDAO;
import com.microservice.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(UserEntity user) {
        userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
