package com.assessment.garage.service;

import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.entity.Car;
import com.assessment.garage.entity.ParkingEntry;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.enums.SlotStatus;
import com.assessment.garage.entity.enums.VehicleType;
import com.assessment.garage.mapper.CustomMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GarageServiceImplTest {

    @InjectMocks
    GarageServiceImpl garageService;

    @Mock
    SlotService slotService;

    @Mock
    VehicleService vehicleService;

    @Mock
    ParkingEntryService parkingEntryService;

    @Mock
    CustomMapper customMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Slot freeSlot = new Slot(1L, SlotStatus.FREE);
        Mockito.when(slotService.getAvailableSlots(Mockito.anyInt()))
                .thenReturn(Collections.singletonList(freeSlot));
        Mockito.when(vehicleService.getByPlate(Mockito.anyString()))
                .thenReturn(Optional.of(new Car("34as", "blue")));
        Mockito.when(parkingEntryService.isCarAlreadyIn(Mockito.anyString())).thenReturn(false);
        Mockito.when(slotService.save(Mockito.any())).thenReturn(new Slot(1L, SlotStatus.OCCUPIED));
        Mockito.when(parkingEntryService.save(Mockito.any())).thenReturn(new ParkingEntry());
        Mockito.when(customMapper.toDto(Mockito.any(ParkingEntry.class))).thenReturn(new ParkingEntryDto());
        ParkingEntry parkingEntry = new ParkingEntry();
        parkingEntry.setProcessingSlots(Collections.singletonList(freeSlot));
        Mockito.when(parkingEntryService.getLastInByPlate(Mockito.anyString())).thenReturn(Optional.of(parkingEntry));
        Mockito.when(parkingEntryService.getAllOccupiedSlotInfo()).thenReturn(Collections.singletonList(parkingEntry));
    }
    @Test
    public void parkVehicle() {
        VehicleDto car = new VehicleDto(1L, "34asd34", "blue", VehicleType.CAR);
        ParkingEntryDto entryDto = garageService.parkVehicle(car);
        Assert.assertNotNull(entryDto);
    }

    @Test
    public void leaveVehicle() {
        VehicleDto car = new VehicleDto(1L, "34asd34", "blue", VehicleType.CAR);
        ParkingEntryDto dto = garageService.leaveVehicle(car);
        Assert.assertNotNull(dto);
    }

    @Test
    public void status() {
        List<ParkingEntryDto> status = garageService.status();
        Assert.assertNotEquals(0, status.size());
    }
}