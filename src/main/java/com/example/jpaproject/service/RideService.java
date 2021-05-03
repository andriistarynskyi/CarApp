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
    private ICarService carService;

    @Autowired
    public RideService(IRideRepository rideRepository, ICarService carService) {
        this.rideRepository = rideRepository;
        this.carService = carService;
    }

    @Override
    @Transactional
    public void save(Ride ride) {
        Car car = ride.getCar();
        car.setTankFull(false);
        carService.save(car);
        rideRepository.save(ride);
    }

    @Override
    public Optional<Ride> findById(int id) {
        return rideRepository.findById(id);
    }
}