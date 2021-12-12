package com.assessment.garage.dto;

import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.Vehicle;
import com.assessment.garage.entity.enums.ParkingProcessType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ParkingEntryDto {
    Long id;
    VehicleDto vehicle;
    LocalDateTime processTime;
    ParkingProcessType processType;
    List<SlotDto> processingSlots;
}
