package com.assessment.garage.dto;

import com.assessment.garage.entity.enums.SlotStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SlotDto implements Serializable {
    private Long id;
    private SlotStatus slotStatus;
}
