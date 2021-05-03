package com.example.jpaproject;

import com.example.jpaproject.entity.Car;
import com.example.jpaproject.entity.CarOwner;
import com.example.jpaproject.entity.Ride;
import com.example.jpaproject.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private ICarService carService;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

//                - Each owner can have multiple cars.
//                - For each ride a driver can select a car. But the car should have a full tank only.
//                - When a car returns a car, he needs to fill the tank to the full.

        ICarOwnerService carOwnerService = ctx.getBean(ICarOwnerService.class);
        ICarService carService = ctx.getBean(ICarService.class);
        IRideService rideService = ctx.getBean(IRideService.class);

        carOwnerService.save(new CarOwner("Alex"));
        System.out.println(carOwnerService.findById(1).get());

        carService.save(new Car("Honda", carOwnerService.findById(1).get(), true));
        carService.save(new Car("Toyota", carOwnerService.findById(1).get(), true));
        carService.save(new Car("Nissan", carOwnerService.findById(1).get(), true));

        rideService.save(new Ride(carOwnerService.findById(1).get(),
                carService.findById(1).get()));
        System.out.println(rideService.findById(1));

        Ride ride = rideService.findById(1).get();
        rideService.completeRide(ride);


    }
}