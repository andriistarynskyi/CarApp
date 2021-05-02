package com.example.jpaproject.repository;

import com.example.jpaproject.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRideRepository extends JpaRepository<Ride, Integer> {
}
