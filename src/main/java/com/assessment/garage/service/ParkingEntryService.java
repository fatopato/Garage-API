package com.assessment.garage.service;

import com.assessment.garage.entity.ParkingEntry;

import java.util.List;
import java.util.Optional;

public interface ParkingEntryService {
    Optional<ParkingEntry> getById(Long id);
    List<ParkingEntry> findAll();
    Optional<ParkingEntry> getLastInByPlate(String plate);
    ParkingEntry save(ParkingEntry entry);
    List<ParkingEntry> getAllOccupiedSlotInfo();
    Boolean isCarAlreadyIn(String plate);
}
