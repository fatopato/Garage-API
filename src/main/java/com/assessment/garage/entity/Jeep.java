package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "VEHICLE")
public class Jeep extends Vehicle {
    public Jeep(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.JEEP;
    }
}
