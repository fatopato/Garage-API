package com.assessment.garage.service;

import com.assessment.garage.entity.Vehicle;
import com.assessment.garage.repository.VehicleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    @NonNull VehicleRepository vehicleRepository;

    @Override
    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.getById(id);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getByPlate(String plate) {
        return vehicleRepository.getByPlate(plate);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
