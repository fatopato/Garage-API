package com.assessment.garage.repository;

import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.enums.SlotStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface SlotRepository extends CrudRepository<Slot, Long> {
    Optional<Slot> getById(Long id);
    List<Slot> findAll();
    List<Slot> findAllBySlotStatus(SlotStatus slotStatus);
    List<Slot> findAllBySlotStatusOrderById(SlotStatus slotStatus);
    Boolean existsSlotByIdAndSlotStatus(Long id, SlotStatus slotStatus);
}
