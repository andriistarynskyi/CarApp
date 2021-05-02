package com.example.jpaproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_owner_id")
    private CarOwner carOwner;
    boolean isTankFull;

    public Car() {
    }

    public Car(String model, CarOwner carOwner, boolean isTankFull) {
        this.model = model;
        this.carOwner = carOwner;
        this.isTankFull = isTankFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public boolean isTankFull() {
        return isTankFull;
    }

    public void setTankFull(boolean tankFull) {
        isTankFull = tankFull;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", carOwner=" + carOwner +
                ", isTankFull=" + isTankFull +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && isTankFull == car.isTankFull && model.equals(car.model) && carOwner.equals(car.carOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, carOwner, isTankFull);
    }
}
