package com.assessment.garage.service;

import com.assessment.garage.entity.ParkingEntry;

import java.util.List;
import java.util.Optional;

public interface ParkingEntryService {
    Optional<ParkingEntry> getById(Long id);
    List<ParkingEntry> findAll();
    List<ParkingEntry> getAllByVehiclePlateOrderByProcessTimeDesc(String plate);
    Optional<ParkingEntry> getLastByPlate(String plate);
}
