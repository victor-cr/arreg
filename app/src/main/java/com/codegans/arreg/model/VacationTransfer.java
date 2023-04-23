package com.codegans.arreg.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public final class VacationTransfer extends Transfer {

    private int plannedDays;

    public VacationTransfer() {

    }
    public VacationTransfer(
            Direction direction,
            Reason reason,
            LocalDate startedAt,
            Person person,
            int plannedDays
    ) {
        super(direction,reason,startedAt,person);
        this.plannedDays = plannedDays;
    }

    public int plannedDays() {
        return plannedDays;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (VacationTransfer) obj;
        return super.equals(that)&&
                this.plannedDays == that.plannedDays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plannedDays);
    }

    @Override
    public String toString() {
        return "VacationTransfer[" +
                super.toString() + ", " +
                "plannedDays=" + plannedDays + ']';
    }

}
