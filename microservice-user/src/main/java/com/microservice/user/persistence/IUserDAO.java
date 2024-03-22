package com.microservice.user.persistence;

import com.microservice.user.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAll();
    void save(UserEntity user);
    void deleteById(Long id);
}
