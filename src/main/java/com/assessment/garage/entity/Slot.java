package com.assessment.garage.entity;

import com.assessment.garage.entity.enums.SlotStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SLOT")
public class Slot implements Serializable {
    @Id
    @NonNull
    private Long id;
    @NonNull
    private SlotStatus slotStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Slot slot = (Slot) o;
        return id != null && Objects.equals(id, slot.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
