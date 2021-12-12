package com.assessment.garage.controller;

import com.assessment.garage.dto.ParkVehicleRequest;
import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.service.GarageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/garage")
public class GarageController {

    @NonNull
    GarageService garageService;

    @PostMapping("/parkVehicle")
    public ParkingEntryDto parkVehicle(@RequestBody VehicleDto dto) {
        return garageService.parkVehicle(dto);
    }

    @DeleteMapping("/leaveVehicle")
    public ParkingEntryDto leaveVehicle(@RequestBody VehicleDto dto) {
        return garageService.leaveVehicle(dto);
    }

    @GetMapping
    public List<ParkingEntryDto> status() {
        return garageService.status();
    }
}
