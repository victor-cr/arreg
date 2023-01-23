package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public record MedicalTransfer(
        UUID id,
        Direction direction,
        Reason reason,
        LocalDate startedAt,
        String clinic,
        String diagnosis
) implements Transfer {
}
