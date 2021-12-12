package com.assessment.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LeaveVehicleRequest {
    private String plate;
}
