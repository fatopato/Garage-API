package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleDto {
    private Long id;
    private String plate;
    private String color;
    private VehicleType vehicleType;
}
