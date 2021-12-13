package com.assessment.garage.service;

import com.assessment.garage.entity.Car;
import com.assessment.garage.entity.Jeep;
import com.assessment.garage.entity.Truck;
import com.assessment.garage.entity.Vehicle;
import com.assessment.garage.repository.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class VehicleServiceImplTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Mock
    VehicleRepository vehicleRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(vehicleRepository.getById(Mockito.anyLong())).thenReturn(Optional.of(new Truck()));
        Mockito.when(vehicleRepository.findAll()).thenReturn(Collections.singletonList(new Car()));
        Mockito.when(vehicleRepository.getByPlate(Mockito.anyString())).thenReturn(Optional.of(new Jeep()));
        Mockito.when(vehicleRepository.save(Mockito.any())).thenReturn(new Jeep());
    }

    @Test
    public void getById() {
        Optional<Vehicle> byId = vehicleService.getById(1L);
        assertTrue(byId.isPresent());
    }

    @Test
    public void findAll() {
        List<Vehicle> all = vehicleService.findAll();
        assertNotEquals(0, all.size());
    }

    @Test
    public void getByPlate() {
        Optional<Vehicle> byPlate = vehicleService.getByPlate("34as21");
        assertTrue(byPlate.isPresent());
    }

    @Test
    public void save() {
        Vehicle vehicle = vehicleService.save(new Jeep());
        assertNotNull(vehicle);
    }
}