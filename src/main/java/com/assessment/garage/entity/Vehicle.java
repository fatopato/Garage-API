package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "VEHICLE")
public abstract class Vehicle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(unique = true, nullable = false)
    String plate;
    @Column(nullable = false)
    String color;
    @Column(nullable = false)
    VehicleType vehicleType;

    public abstract VehicleType getVehicleType();

    protected Vehicle(String plate, String color) {
        this.plate = plate;
        this.color = color;
        this.vehicleType = getVehicleType();
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
