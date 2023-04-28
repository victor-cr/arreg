package com.codegans.arreg.model.dto;

import com.codegans.arreg.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class PersonDto {
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String birthPlace;
    private String itn;
    private String bloodGroup;
    private String bloodRhD;

    public PersonDto(Person person) {
        this.id = person.id().toString();
        this.firstName = person.firstName();
        this.lastName = person.lastName();
        this.middleName = person.middleName();
        this.birthDate = person.birthDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.birthPlace = person.birthPlace();
        this.itn = person.itn();
        this.bloodGroup = person.bloodGroup().name();
        this.bloodRhD = person.bloodRhD().name();
    }
}