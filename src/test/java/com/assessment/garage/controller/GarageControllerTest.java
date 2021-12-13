package com.assessment.garage.controller;

import com.assessment.garage.dto.BaseResponse;
import com.assessment.garage.dto.ParkingEntryDto;
import com.assessment.garage.dto.VehicleDto;
import com.assessment.garage.service.GarageService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.Assert.*;

public class GarageControllerTest {

    @InjectMocks
    GarageController garageController;

    @Mock
    GarageService garageService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(garageService.parkVehicle(Mockito.any())).thenReturn(new ParkingEntryDto());
        Mockito.when(garageService.leaveVehicle(Mockito.any())).thenReturn(new ParkingEntryDto());
        Mockito.when(garageService.status()).thenReturn(Collections.singletonList(new ParkingEntryDto()));
    }

    @Test
    public void parkVehicle() {
        BaseResponse baseResponse = garageController.parkVehicle(new VehicleDto());
        Assert.assertNotNull(baseResponse.getData());
    }

    @Test
    public void leaveVehicle() {
        BaseResponse baseResponse = garageController.leaveVehicle(new VehicleDto());
        Assert.assertNotNull(baseResponse.getData());
    }

    @Test
    public void status() {
        BaseResponse baseResponse = garageController.status();
        Assert.assertNotNull(baseResponse.getData());
    }
}