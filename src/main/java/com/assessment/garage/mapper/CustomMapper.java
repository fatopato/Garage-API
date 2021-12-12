package com.assessment.garage.mapper;

import com.assessment.garage.dto.SlotDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.Vehicle;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomMapper {

    public SlotDto toDto(Slot entity) {
        return new SlotDto(entity.getId(), entity.getSlotStatus());
    }

    public Slot toEntity(SlotDto dto) {
        return new Slot(dto.getId(), dto.getSlotStatus());
    }

    public VehicleDto toDto(Vehicle entity) {
        return new VehicleDto(entity.getId(), entity.getPlate(), entity.getColor(), entity.getVehicleType());
    }

    public Vehicle toEntity(VehicleDto dto) {
        Vehicle vehicle = dto.getVehicleType().getVehicle(dto.getPlate(), dto.getColor());
        vehicle.setId(dto.getId());
        return vehicle;
    }

}
