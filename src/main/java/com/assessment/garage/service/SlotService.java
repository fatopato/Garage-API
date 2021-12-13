package com.assessment.garage.service;

import com.assessment.garage.entity.Slot;

import java.util.List;
import java.util.Optional;

public interface SlotService {
    Slot save (Slot slot);
    Optional<Slot> update(Slot slot);
    Optional<Slot> getById(Long id);
    List<Slot> getAll();
    List<Slot> getFreeSlots();
    List<Slot> getAvailableSlots(int slotSize);
    List<Slot> getOccupiedSlots(int slotSize);
    boolean isSlotFree(Long id);
    Optional<Slot> fullById(Long id);
    Optional<Slot> freeById(Long id);
}
