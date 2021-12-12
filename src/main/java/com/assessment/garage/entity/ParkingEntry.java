package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.ParkingProcessType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

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
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime processTime;
    @Column(nullable = false)
    private ParkingProcessType processType;
    @OneToMany
    private List<Slot> processingSlots;
}
