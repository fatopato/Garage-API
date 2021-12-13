package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JeepDto extends VehicleDto {
    public JeepDto(String plate, String color) {
        super(plate, color);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.JEEP;
    }
}
