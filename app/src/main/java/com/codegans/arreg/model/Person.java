package com.codegans.arreg.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public final class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  UUID id;
    private  String lastName;
    private  String firstName;
    private  String middleName;
    private  LocalDate birthDate;
    private  String birthPlace;
    @Column(unique=true)
    private  String itn;
    private  BloodGroup bloodGroup;
    private  BloodRhD bloodRhD;
    @OneToOne(optional = true)
    private MilitaryIdentityCard  militaryIdentityCard;
    @OneToMany(cascade = CascadeType.ALL)
    private List<VacationTransfer> vacationTransfers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MedicalTransfer> medicalTransfers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RegularTransfer> regularTransfers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<AssessmentTransfer> assessmentTransfers;

    public Person() {
    }

    public Person(
            String lastName,
            String firstName,
            String middleName,
            LocalDate birthDate,
            String birthPlace,
            String itn,
            BloodGroup bloodGroup,
            BloodRhD bloodRhD
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.itn = itn;
        this.bloodGroup = bloodGroup;
        this.bloodRhD = bloodRhD;
    }


    public UUID id() {
        return id;
    }

    public String lastName() {
        return lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String middleName() {
        return middleName;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    public String birthPlace() {
        return birthPlace;
    }

    public String itn() {
        return itn;
    }

    public BloodGroup bloodGroup() {
        return bloodGroup;
    }

    public BloodRhD bloodRhD() {
        return bloodRhD;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.middleName, that.middleName) &&
                Objects.equals(this.birthDate, that.birthDate) &&
                Objects.equals(this.birthPlace, that.birthPlace) &&
                Objects.equals(this.itn, that.itn) &&
                Objects.equals(this.bloodGroup, that.bloodGroup) &&
                Objects.equals(this.bloodRhD, that.bloodRhD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, birthDate, birthPlace, itn, bloodGroup, bloodRhD);
    }

    @Override
    public String toString() {
        return "Person[" +
                "id=" + id + ", " +
                "lastName=" + lastName + ", " +
                "firstName=" + firstName + ", " +
                "middleName=" + middleName + ", " +
                "birthDate=" + birthDate + ", " +
                "birthPlace=" + birthPlace + ", " +
                "itn=" + itn + ", " +
                "bloodGroup=" + bloodGroup + ", " +
                "bloodRhD=" + bloodRhD + ']';
    }


}
