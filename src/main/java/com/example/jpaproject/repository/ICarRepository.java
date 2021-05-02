package com.example.jpaproject.repository;

import com.example.jpaproject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car, Integer> {
}
