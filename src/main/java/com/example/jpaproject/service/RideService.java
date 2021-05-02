package com.example.jpaproject.service;

import com.example.jpaproject.entity.Car;
import com.example.jpaproject.entity.Ride;
import com.example.jpaproject.repository.IRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RideService implements IRideService {

    private IRideRepository rideRepository;

    @Autowired

    public RideService(IRideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    @Transactional
    public void save(Ride ride) {
        Car car = ride.getCar();
        car.setTankFull(false);
        rideRepository.save(ride);
    }

    @Override
    public Optional<Ride> findById(int id) {
        return rideRepository.findById(id);
    }
}
