package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.VehicleType;

public class Jeep extends Vehicle {
    public Jeep(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.JEEP;
    }
}
