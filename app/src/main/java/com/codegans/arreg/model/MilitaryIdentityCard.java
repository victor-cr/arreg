package com.codegans.arreg.model;

import java.time.LocalDate;

public record MilitaryIdentityCard(
        String serialNumber,
        Person person,
        String issuedBy,
        LocalDate issuedAt,
        String education,
        String civilOccupation,
        MaritalStatus maritalStatus
) {
}
