package com.microservice.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.shipments.entities.ShipmentsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    private String address;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ShipmentsEntity.class, mappedBy ="userEntity")
    @JsonIgnore
    private List<ShipmentsEntity> bikeEntityList = new ArrayList<>();


}
