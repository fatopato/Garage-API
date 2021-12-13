package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CarDto extends VehicleDto {

    public CarDto(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
