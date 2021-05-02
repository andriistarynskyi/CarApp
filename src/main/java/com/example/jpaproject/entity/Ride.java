package com.example.jpaproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private CarOwner carOwner;
    @OneToOne
    private Car car;

    public Ride() {
    }

    public Ride(CarOwner carOwner, Car car) {
        this.carOwner = carOwner;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", carOwner=" + carOwner +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return id == ride.id && carOwner.equals(ride.carOwner) && car.equals(ride.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carOwner, car);
    }
}
