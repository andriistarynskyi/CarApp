package com.example.jpaproject.service;

import com.example.jpaproject.entity.Car;

import java.util.Optional;

public interface ICarService {
    void save(Car car);

    Optional<Car> findById(int id);
}
