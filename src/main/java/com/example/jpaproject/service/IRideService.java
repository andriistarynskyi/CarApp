package com.example.jpaproject.service;

import com.example.jpaproject.entity.Ride;

import java.util.Optional;

public interface IRideService {
    void save(Ride ride);

    Optional<Ride> findById(int id);

    void completeRide(Ride ride);
}