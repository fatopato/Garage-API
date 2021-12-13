package com.assessment.garage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingEntryDto {
    Long id;
    VehicleDto vehicle;
    LocalDateTime entranceTime;
    LocalDateTime leavingTime;
    List<SlotDto> processingSlots;
}
