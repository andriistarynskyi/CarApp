package com.example.jpaproject.service;

import com.example.jpaproject.entity.Car;
import com.example.jpaproject.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CarService implements ICarService {
    private ICarRepository carRepository;

    @Autowired
    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    @Transactional
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Optional<Car> findById(int id) {
        return carRepository.findById(id);
    }
}
