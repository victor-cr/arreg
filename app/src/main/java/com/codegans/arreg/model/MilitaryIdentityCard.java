package com.codegans.arreg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public final class MilitaryIdentityCard {
    @Id
    private String serialNumber;
    @OneToOne(optional = false)
    private Person person;
    private String issuedBy;
    private LocalDate issuedAt;
    private String education;
    private String civilOccupation;
    private MaritalStatus maritalStatus;


    public MilitaryIdentityCard() {
    }

    public MilitaryIdentityCard(
            String serialNumber,
            Person person,
            String issuedBy,
            LocalDate issuedAt,
            String education,
            String civilOccupation,
            MaritalStatus maritalStatus
    ) {
        this.serialNumber = serialNumber;
        this.person = person;
        this.issuedBy = issuedBy;
        this.issuedAt = issuedAt;
        this.education = education;
        this.civilOccupation = civilOccupation;
        this.maritalStatus = maritalStatus;
    }

    public String serialNumber() {
        return serialNumber;
    }

    public Person person() {
        return person;
    }

    public String issuedBy() {
        return issuedBy;
    }

    public LocalDate issuedAt() {
        return issuedAt;
    }

    public String education() {
        return education;
    }

    public String civilOccupation() {
        return civilOccupation;
    }

    public MaritalStatus maritalStatus() {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (MilitaryIdentityCard) obj;
        return Objects.equals(this.serialNumber, that.serialNumber) &&
                Objects.equals(this.person, that.person) &&
                Objects.equals(this.issuedBy, that.issuedBy) &&
                Objects.equals(this.issuedAt, that.issuedAt) &&
                Objects.equals(this.education, that.education) &&
                Objects.equals(this.civilOccupation, that.civilOccupation) &&
                Objects.equals(this.maritalStatus, that.maritalStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, person, issuedBy, issuedAt, education, civilOccupation, maritalStatus);
    }

    @Override
    public String toString() {
        return "MilitaryIdentityCard[" +
                "serialNumber=" + serialNumber + ", " +
                "person=" + person + ", " +
                "issuedBy=" + issuedBy + ", " +
                "issuedAt=" + issuedAt + ", " +
                "education=" + education + ", " +
                "civilOccupation=" + civilOccupation + ", " +
                "maritalStatus=" + maritalStatus + ']';
    }

}
