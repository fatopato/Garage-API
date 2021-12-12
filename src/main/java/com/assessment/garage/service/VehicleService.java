package com.assessment.garage.service;

import com.assessment.garage.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Optional<Vehicle> getById(Long id);

    List<Vehicle> findAll();

    Optional<Vehicle> getByPlate(String plate);

    Vehicle save(Vehicle vehicle);
}
