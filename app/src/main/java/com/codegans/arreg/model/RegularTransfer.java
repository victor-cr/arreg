package com.codegans.arreg.model;

import java.time.LocalDate;
import java.util.UUID;

public record RegularTransfer(
        UUID id,
        Direction direction,
        Reason reason,
        LocalDate startedAt
) implements Transfer {
}
