package com.example.jpaproject.service;

import com.example.jpaproject.entity.CarOwner;
import com.example.jpaproject.repository.ICarOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CarOwnerService implements ICarOwnerService {

    private ICarOwnerRepository carOwnerRepository;

    @Autowired
    public CarOwnerService(ICarOwnerRepository carOwnerRepository) {
        this.carOwnerRepository = carOwnerRepository;
    }

    @Override
    @Transactional
    public void save(CarOwner carOwner) {
        carOwnerRepository.save(carOwner);
    }

    @Override
    public Optional<CarOwner> findById(int id) {
        return carOwnerRepository.findById(id);
    }
}
