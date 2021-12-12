package com.assessment.garage.repository;

import com.assessment.garage.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Optional<Vehicle> getById(Long id);

    List<Vehicle> findAll();

    Optional<Vehicle> getByPlate(String plate);
}
