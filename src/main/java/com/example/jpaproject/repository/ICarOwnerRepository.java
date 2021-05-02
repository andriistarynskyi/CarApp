package com.example.jpaproject.repository;

import com.example.jpaproject.entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarOwnerRepository extends JpaRepository<CarOwner, Integer> {
}
