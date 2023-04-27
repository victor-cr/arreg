package com.codegans.arreg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "TRANSFER_ID")
public final class RegularTransfer extends Transfer {

    public RegularTransfer() {
    }

    public RegularTransfer(
            Direction direction,
            Reason reason,
            LocalDate startedAt,
            Person person
    ) {
        super(direction, reason, startedAt, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RegularTransfer) obj;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "RegularTransfer[" +
                super.toString() + ']';
    }

}
