package com.microservice.user.repository;

import com.microservice.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {



}
