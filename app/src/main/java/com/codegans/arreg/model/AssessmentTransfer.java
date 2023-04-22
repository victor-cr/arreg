package com.codegans.arreg.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public final class AssessmentTransfer extends Transfer {

    private String location;

    public AssessmentTransfer() {

    }
    public AssessmentTransfer(
            Direction direction,
            Reason reason,
            LocalDate startedAt,
            String location,
            Person person
    ) {
        super(direction, reason, startedAt, person);
        this.location = location;
    }

    public String location() {
        return location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AssessmentTransfer) obj;
        return super.equals(that) &&
                Objects.equals(this.location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }

    @Override
    public String toString() {
        return "AssessmentTransfer[" +
                super.toString() + ", " +
                "location=" + location + ']';
    }

}
