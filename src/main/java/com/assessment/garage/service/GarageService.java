package com.assessment.garage.service;

import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;

import java.util.List;

public interface GarageService {
    ParkingEntryDto parkVehicle(VehicleDto dto);
    ParkingEntryDto leaveVehicle(VehicleDto dto);
    List<ParkingEntryDto> status();
}
