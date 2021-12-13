package com.assessment.garage.controller;

import com.assessment.garage.dto.SlotDto;
import com.assessment.garage.entity.Slot;
import com.assessment.garage.mapper.CustomMapper;
import com.assessment.garage.service.SlotService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/slot")
public class SlotController {
    @NonNull SlotService slotService;
    @NonNull CustomMapper customMapper;

    @PostMapping(value = "")
    public SlotDto create(@RequestBody SlotDto slot) {
       return customMapper.toDto(slotService.save(customMapper.toEntity(slot)));
    }

    @PutMapping(value = "")
    public SlotDto update(@RequestBody SlotDto slotDto) {
       return slotService.update(customMapper.toEntity(slotDto)).map(customMapper::toDto).orElse(null);
    }

    @GetMapping(value = "")
    public List<SlotDto> getAll() {
        return slotService.getAll().stream().map(customMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/free")
    public List<SlotDto> getAllFreeSlots() {
        return slotService.getFreeSlots().stream().map(customMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/getById/{id}")
    public SlotDto getById(@PathVariable  Long id) {
        Optional<Slot> optionalSlot = slotService.getById(id);
        return optionalSlot.map(customMapper::toDto).orElse(null);
    }

    @PutMapping(value = "/fullById/{id}")
    public SlotDto fullById(@PathVariable  Long id) {
        Optional<Slot> optionalSlot = slotService.fullById(id);
        return optionalSlot.map(customMapper::toDto).orElse(null);
    }

    @PutMapping(value = "/freeById/{id}")
    public SlotDto freeById(@PathVariable  Long id) {
        Optional<Slot> optionalSlot = slotService.freeById(id);
        return optionalSlot.map(customMapper::toDto).orElse(null);
    }

    @GetMapping(value = "/getAvailable/{slotSize}")
    public List<SlotDto> getAvailable(@PathVariable  Integer slotSize) {
        return slotService.getAvailableSlots(slotSize).stream().map(customMapper::toDto).collect(Collectors.toList());
    }
}
