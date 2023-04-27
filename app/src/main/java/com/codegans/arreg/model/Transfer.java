package com.codegans.arreg.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;
    @Enumerated(EnumType.STRING)
    private  Direction direction;
    @Enumerated(EnumType.STRING)
    private  Reason reason;
    private  LocalDate startedAt;
    @OneToOne(optional = false)
    private Person person;

    public Transfer() {
    }

    public Transfer( Direction direction, Reason reason, LocalDate startedAt, Person person) {
        this.direction = direction;
        this.reason = reason;
        this.startedAt = startedAt;
        this.person = person;
    }

    public UUID id() {
        return id;
    }

    public Direction direction() {
        return direction;
    }

    public Reason reason() {
        return reason;
    }

    public LocalDate startedAt() {
        return startedAt;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Transfer) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.direction, that.direction) &&
                Objects.equals(this.reason, that.reason) &&
                Objects.equals(this.startedAt, that.startedAt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direction, reason, startedAt);
    }

    @Override
    public String toString() {
        return "Transfer[" +
                "id=" + id + ", " +
                "direction=" + direction + ", " +
                "reason=" + reason + ", " +
                "startedAt=" + startedAt + ", " + ']';
    }
}
