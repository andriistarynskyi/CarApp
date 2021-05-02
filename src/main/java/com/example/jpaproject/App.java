package com.example.jpaproject;

import com.example.jpaproject.entity.Car;
import com.example.jpaproject.entity.CarOwner;
import com.example.jpaproject.entity.Ride;
import com.example.jpaproject.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

//                - Each owner can have multiple cars.
//                - For each ride a driver can select a car. But the car should have a full tank only.
//                - When a car returns a car, he needs to fill the tank to the full.

        ICarOwnerService carOwnerService = ctx.getBean(CarOwnerService.class);
        ICarService carService = ctx.getBean(CarService.class);
        IRideService rideService = ctx.getBean(RideService.class);

        carService.save(new Car("Honda Accord", new CarOwner("Alex"), true));
        carService.save(new Car("Toyota Corolla",
                carOwnerService.findById(1).orElseThrow(RuntimeException::new),
                true));
        carService.save(new Car("Aston Martin",
                carOwnerService.findById(1).orElseThrow(RuntimeException::new),
                true));

        rideService.save(new Ride(carOwnerService.findById(1).orElseThrow(RuntimeException::new),
                carService.findById(1).orElseThrow(RuntimeException::new)));
    }
}
