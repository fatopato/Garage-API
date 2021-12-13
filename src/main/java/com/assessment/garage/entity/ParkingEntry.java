package com.assessment.garage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PARKING_ENTRY")
public class ParkingEntry {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @Column(nullable = false)
    private LocalDateTime entranceTime;
    private LocalDateTime leavingTime;
    @ManyToMany
    private List<Slot> processingSlots;
}
