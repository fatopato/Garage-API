package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class VehicleDto {
    @JsonIgnore
    private Long id;
    @NonNull
    private String plate;
    @NonNull
    private String color;
    @NonNull
    private VehicleType vehicleType;
}
