package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public record Person(
        UUID id,
        String lastName,
        String firstName,
        String middleName,
        LocalDate birthDate,
        String birthPlace,
        String itn,
        BloodGroup bloodGroup,
        BloodRhD bloodRhD
) {

}
