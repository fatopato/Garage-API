package com.assessment.garage.entity.enums;

import com.assessment.garage.dto.CarDto;
import com.assessment.garage.dto.JeepDto;
import com.assessment.garage.dto.TruckDto;
import com.assessment.garage.dto.VehicleDto;

public enum VehicleType {

    CAR(1) {
        @Override
        public VehicleDto getVehicle(String plate, String color) {
            return new CarDto(plate, color);
        }
    },
    JEEP(2) {
        @Override
        public VehicleDto getVehicle(String plate, String color) {
            return new JeepDto(plate, color);
        }
    },
    TRUCK(4) {
        @Override
        public VehicleDto getVehicle(String plate, String color) {
            return new TruckDto(plate, color);
        }
    };

    private final int slotSize;

    public abstract VehicleDto getVehicle(String plate, String color);

    VehicleType(int slotSize) {
        this.slotSize = slotSize;
    }

    public int getSlotSize() {
        return this.slotSize;
    }
}
