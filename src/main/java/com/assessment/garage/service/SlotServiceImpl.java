package com.assessment.garage.service;

import com.assessment.garage.entity.Slot;
import com.assessment.garage.entity.enums.SlotStatus;
import com.assessment.garage.repository.SlotRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotServiceImpl implements SlotService {
    @NonNull
    private SlotRepository slotRepository;

    public Slot save (Slot slot) {
        return slotRepository.save(slot);
    }

    public Optional<Slot> update(Slot slot) {
        Optional<Slot> slotOptional = this.getById(slot.getId());
        if (slotOptional.isPresent()){
            return Optional.of(slotRepository.save(slot));
        }
        return Optional.empty();
    }

    public Optional<Slot> getById(Long id) {
        return slotRepository.getById(id);
    }

    public List<Slot> getAll() {
        return slotRepository.findAll();
    }

    public List<Slot> getFreeSlots() {
        return slotRepository.findAllBySlotStatus(SlotStatus.FREE);
    }

    @Synchronized
    public List<Slot> getAvailableSlots(int slotSize) {
        List<Slot> freeSlots = slotRepository.findAllBySlotStatusOrderById(SlotStatus.FREE);
        List<Long> ids = freeSlots.stream().map(Slot::getId).collect(Collectors.toList());
        List<Long> available = this.findAvailable(ids, slotSize);
        return freeSlots.stream().filter(e -> available.contains(e.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Slot> getOccupiedSlots(int slotSize) {
        return slotRepository.findAllBySlotStatus(SlotStatus.OCCUPIED);
    }

    private List<Long> findAvailable(List<Long> ids, int slotSize) {
        List<Long> result = Collections.emptyList();
        if (ids.size() < slotSize) {
            return result;
        }
        if (slotSize == 1) {
            return ids.subList(0, 1);
        }
        try {
            for (int i = 0 ; i < ids.size() ; i++) {
                if (ids.get(i+slotSize-1) - ids.get(i) == slotSize -1) {
                    return ids.subList(i, i+slotSize);
                }
            }
        }catch (IndexOutOfBoundsException e){
            return result;
        }
        return result;
    }

    public boolean isSlotFree(Long id) {
        return slotRepository.existsSlotByIdAndSlotStatus(id, SlotStatus.FREE);
    }

    @Override
    public Optional<Slot> fullById(Long id) {
        Optional<Slot> optionalSlot = this.getById(id);

        if (optionalSlot.isPresent()){
            Slot slot = optionalSlot.get();
            slot.setSlotStatus(SlotStatus.OCCUPIED);
            return Optional.of(slotRepository.save(slot));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Slot> freeById(Long id) {
        Optional<Slot> optionalSlot = this.getById(id);

        if (optionalSlot.isPresent()){
            Slot slot = optionalSlot.get();
            slot.setSlotStatus(SlotStatus.FREE);
            return Optional.of(slotRepository.save(slot));
        }
        return Optional.empty();
    }
}
