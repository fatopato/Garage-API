package com.assessment.garage.repository;

import com.assessment.garage.entity.ParkingEntry;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ParkingEntryRepository extends CrudRepository<ParkingEntry, Long> {
    Optional<ParkingEntry> getById(Long id);
    List<ParkingEntry> findAll();
    List<ParkingEntry> findAllByLeavingTimeIsNull();
    Optional<ParkingEntry> findTopByVehiclePlateAndLeavingTimeOrderByEntranceTimeDesc(String plate, LocalDateTime leavingTime);
    Boolean existsByVehiclePlateAndLeavingTimeIsNull(String plate);
}
