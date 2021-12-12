package com.assessment.garage.service;

import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.entity.ParkingEntry;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.Vehicle;
import com.assessment.garage.mapper.CustomMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GarageServiceImpl implements GarageService {

    @NonNull
    SlotService slotService;

    @NonNull
    VehicleService vehicleService;

    @NonNull CustomMapper customMapper;

    @Override
    public ParkingEntryDto parkVehicle(VehicleDto dto) {
        List<Slot> availableSlots = slotService.getAvailableSlots(dto.getVehicleType().getSlotSize());
        Vehicle savedVehicle = vehicleService.save(customMapper.toEntity(dto));
        ParkingEntry parkingEntry = new ParkingEntry();
        parkingEntry.setVehicle(savedVehicle);
        parkingEntry.setProcessingSlots(availableSlots);

        return null;
    }

    @Override
    public ParkingEntryDto leaveVehicle(VehicleDto dto) {
        return null;
    }

    @Override
    public List<ParkingEntryDto> status() {
        return null;
    }
}
