package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public interface Transfer {
    UUID id();

    Direction direction();

    Reason reason();

    LocalDate startedAt();
}
