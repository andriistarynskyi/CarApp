package com.example.jpaproject.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;

    public CarOwner() {
    }

    public CarOwner(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwner carOwner = (CarOwner) o;
        return id == carOwner.id && fullName.equals(carOwner.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }
}
