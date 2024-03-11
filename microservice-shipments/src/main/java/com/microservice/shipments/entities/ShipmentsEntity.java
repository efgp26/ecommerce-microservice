package com.microservice.shipments.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.user.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shipments_ecommerce")
public class ShipmentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StadeShipment stade;

    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity userEntity;


}
