package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public record AssessmentTransfer(
        UUID id,
        Direction direction,
        Reason reason,
        LocalDate startedAt,
        String location
) implements Transfer {
}
