package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public record VacationTransfer(
        UUID id,
        Direction direction,
        Reason reason,
        LocalDate startedAt,
        int plannedDays
) implements Transfer {
}
