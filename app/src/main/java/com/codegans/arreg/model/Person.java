package com.codegans.arreg.model;

import java.util.UUID;

public record Person(
        UUID id,
        String lastName,
        String firstName,
        String middleName
) {

}
