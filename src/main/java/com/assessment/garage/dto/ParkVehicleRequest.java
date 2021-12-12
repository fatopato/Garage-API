package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ParkVehicleRequest {
    private String plate;
    private String color;
    private VehicleType vehicleType;
}
