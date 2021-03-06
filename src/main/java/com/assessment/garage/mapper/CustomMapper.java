package com.assessment.garage.mapper;

import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.SlotDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.entity.ParkingEntry;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.Vehicle;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class CustomMapper {

    public SlotDto toDto(Slot entity) {
        return new SlotDto(entity.getId(), entity.getSlotStatus());
    }

    public Slot toEntity(SlotDto dto) {
        return new Slot(dto.getId(), dto.getSlotStatus());
    }

    public VehicleDto toDto(Vehicle entity) {
        VehicleDto vehicleDto = entity.getVehicleType().getVehicle(entity.getPlate(), entity.getColor());
        vehicleDto.setId(entity.getId());
        return vehicleDto;
    }

    public Vehicle toEntity(VehicleDto dto) {
        return new Vehicle(dto.getId(), dto.getPlate(), dto.getColor(), dto.getVehicleType());
    }

    public ParkingEntryDto toDto(ParkingEntry entity) {
        ParkingEntryDto dto = new ParkingEntryDto();
        dto.setId(entity.getId());
        dto.setVehicle(this.toDto(entity.getVehicle()));
        dto.setEntranceTime(entity.getEntranceTime());
        dto.setProcessingSlots(entity.getProcessingSlots().stream().map(this::toDto).collect(Collectors.toList()));
        return dto;
    }

    public ParkingEntry toEntity(ParkingEntryDto dto) {
        ParkingEntry entity = new ParkingEntry();
        entity.setId(dto.getId());
        entity.setVehicle(this.toEntity(dto.getVehicle()));
        entity.setEntranceTime(entity.getEntranceTime());
        entity.setProcessingSlots(dto.getProcessingSlots().stream().map(this::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
