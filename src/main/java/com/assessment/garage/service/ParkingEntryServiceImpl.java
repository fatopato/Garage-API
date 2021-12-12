package com.assessment.garage.service;

import com.assessment.garage.entity.ParkingEntry;
import com.assessment.garage.repository.ParkingEntryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ParkingEntryServiceImpl implements ParkingEntryService {

    @NonNull ParkingEntryRepository parkingEntryRepository;

    @Override
    public Optional<ParkingEntry> getById(Long id) {
        return parkingEntryRepository.getById(id);
    }

    @Override
    public List<ParkingEntry> findAll() {
        return parkingEntryRepository.findAll();
    }

    @Override
    public List<ParkingEntry> getAllByVehiclePlateOrderByProcessTimeDesc(String plate) {
        return parkingEntryRepository.getAllByVehiclePlateOrderByProcessTimeDesc(plate);
    }

    @Override
    public Optional<ParkingEntry> getLastByPlate(String plate) {
        return parkingEntryRepository.findTopByVehiclePlateOrderByProcessTimeDesc(plate);
    }
}
