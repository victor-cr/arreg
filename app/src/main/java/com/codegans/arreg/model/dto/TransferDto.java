package com.codegans.arreg.model.dto;

import com.codegans.arreg.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class TransferDto {
    private String type;
    private String direction;
    private String reason;
    private String startDate;
    private String details;

    public TransferDto(Transfer transfer) {
        this.direction = transfer.direction().name();
        this.reason = transfer.reason().name();
        this.startDate = transfer.startedAt().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public TransferDto(RegularTransfer transfer) {
        this((Transfer) transfer);
        this.type = "Regular";
    }

    public TransferDto(MedicalTransfer transfer) {
        this((Transfer) transfer);
        this.type = "Medical";
        this.details = String.format("Clinic: %s, Diagnosis: %s", transfer.clinic(), transfer.diagnosis());
    }

    public TransferDto(VacationTransfer transfer) {
        this((Transfer) transfer);
        this.type = "Vacation";
        this.details = String.format("Planed for %d days", transfer.plannedDays());
    }

    public TransferDto(AssessmentTransfer transfer) {
        this((Transfer) transfer);
        this.type = "Assessment";
        this.details = String.format("Transferred to %s", transfer.location());
    }

}
