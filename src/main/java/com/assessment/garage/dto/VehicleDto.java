package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    @JsonIgnore
    private Long id;
    @NonNull
    private String plate;
    @NonNull
    private String color;
    @NonNull
    private VehicleType vehicleType;

    protected VehicleDto(String plate, String color) {
        this.plate = plate;
        this.color = color;
        this.vehicleType = getVehicleType();
    }
}
