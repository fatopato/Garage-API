package com.assessment.garage.controller;

import com.assessment.garage.dto.BaseResponse;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.service.GarageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/garage")
public class GarageController {

    @NonNull
    GarageService garageService;

    @PostMapping("/parkVehicle")
    public BaseResponse parkVehicle(@RequestBody VehicleDto dto) {
        try {
            return new BaseResponse(garageService.parkVehicle(dto), "", HttpStatus.OK);
        }catch (Exception e) {
            return new BaseResponse(null, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/leaveVehicle")
    public BaseResponse leaveVehicle(@RequestBody VehicleDto dto) {
        try {
            return new BaseResponse(garageService.leaveVehicle(dto), "", HttpStatus.OK);
        }catch (Exception e) {
            return new BaseResponse(null, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/status")
    public BaseResponse status() {
        try {
            return new BaseResponse(garageService.status(), "", HttpStatus.OK);
        }catch (Exception e) {
            return new BaseResponse(null, e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
