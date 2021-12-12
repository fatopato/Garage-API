package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }
}
