package com.example.jpaproject.service;

import com.example.jpaproject.entity.CarOwner;

import java.util.Optional;

public interface ICarOwnerService {
    void save(CarOwner carOwner);

    Optional<CarOwner> findById(int id);
}
