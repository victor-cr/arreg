package com.codegans.arreg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "TRANSFER_ID")
public final class MedicalTransfer extends Transfer {
    private String clinic;
    private String diagnosis;

    public MedicalTransfer() {
    }

    public MedicalTransfer(
            Direction direction,
            Reason reason,
            LocalDate startedAt,
            String clinic,
            String diagnosis,
            Person person
    ) {
        super(direction, reason, startedAt, person);
        this.clinic = clinic;
        this.diagnosis = diagnosis;
    }


    public String clinic() {
        return clinic;
    }

    public String diagnosis() {
        return diagnosis;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MedicalTransfer) obj;
        return super.equals(that) &&
                Objects.equals(this.clinic, that.clinic) &&
                Objects.equals(this.diagnosis, that.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clinic, diagnosis);
    }

    @Override
    public String toString() {
        return "MedicalTransfer[" +
                super.toString() + ", " +
                "clinic=" + clinic + ", " +
                "diagnosis=" + diagnosis + ']';
    }

}
