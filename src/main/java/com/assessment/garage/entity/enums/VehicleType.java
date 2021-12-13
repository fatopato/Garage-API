package com.assessment.garage.entity.enums;

import com.assessment.garage.entity.Car;
import com.assessment.garage.entity.Jeep;
import com.assessment.garage.entity.Truck;
import com.assessment.garage.entity.Vehicle;

public enum VehicleType {

    CAR(1) {
        @Override
        public Vehicle getVehicle(String plate, String color) {
            return new Car(plate, color);
        }
    },
    JEEP(2) {
        @Override
        public Vehicle getVehicle(String plate, String color) {
            return new Jeep(plate, color);
        }
    },
    TRUCK(4) {
        @Override
        public Vehicle getVehicle(String plate, String color) {
            return new Truck(plate, color);
        }
    };

    private final int slotSize;

    public abstract Vehicle getVehicle(String plate, String color);

    VehicleType(int slotSize) {
        this.slotSize = slotSize;
    }

    public int getSlotSize() {
        return this.slotSize;
    }
}
