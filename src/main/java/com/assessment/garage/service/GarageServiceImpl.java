package com.assessment.garage.service;

import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.entity.ParkingEntry;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.Vehicle;
import com.assessment.garage.entity.enums.SlotStatus;
import com.assessment.garage.mapper.CustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GarageServiceImpl implements GarageService {

    @NonNull
    SlotService slotService;

    @NonNull
    VehicleService vehicleService;

    @NonNull
    ParkingEntryService parkingEntryService;

    @NonNull
    CustomMapper customMapper;

    @Override
    public ParkingEntryDto parkVehicle(VehicleDto dto) {
        List<Slot> availableSlots = slotService.getAvailableSlots(dto.getVehicleType().getSlotSize());
        if (availableSlots.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("There is not enough available slot in the garage");
        }
        Optional<Vehicle> optionalVehicle = vehicleService.getByPlate(dto.getPlate());
        Vehicle savedVehicle;
        savedVehicle = optionalVehicle.orElseGet(() -> vehicleService.save(customMapper.toEntity(dto)));
        boolean isCarIn = parkingEntryService.isCarAlreadyIn(savedVehicle.getPlate());
        if (isCarIn) {
            throw new IllegalArgumentException("The car is already in the garage!!!");
        }
        ParkingEntry parkingEntry = new ParkingEntry();
        parkingEntry.setVehicle(savedVehicle);
        availableSlots.forEach(slot -> {
            slot.setSlotStatus(SlotStatus.OCCUPIED);
            slotService.save(slot);
        });
        parkingEntry.setProcessingSlots(availableSlots);
        parkingEntry.setEntranceTime(LocalDateTime.now());
        parkingEntry.setLeavingTime(null);
        ParkingEntry savedEntry = parkingEntryService.save(parkingEntry);
        return customMapper.toDto(savedEntry);
    }

    @Override
    public ParkingEntryDto leaveVehicle(VehicleDto dto) {
        Optional<ParkingEntry> optionalParkingEntry = parkingEntryService.getLastInByPlate(dto.getPlate());
        ParkingEntry parkingEntry = optionalParkingEntry.orElseThrow(
                () -> new IllegalArgumentException("Car is not the garage"));

        parkingEntry.getProcessingSlots().forEach(slot -> {
            slot.setSlotStatus(SlotStatus.FREE);
            slotService.save(slot);
        });
        parkingEntry.setLeavingTime(LocalDateTime.now());
        ParkingEntry savedEntry = parkingEntryService.save(parkingEntry);
        return customMapper.toDto(savedEntry);
    }

    @Override
    public List<ParkingEntryDto> status() {
        return parkingEntryService.getAllOccupiedSlotInfo().stream().map(e -> customMapper.toDto(e)).collect(Collectors.toList());
    }
}
