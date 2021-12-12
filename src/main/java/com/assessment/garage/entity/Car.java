package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
