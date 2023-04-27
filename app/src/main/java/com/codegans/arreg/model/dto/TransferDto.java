package com.codegans.arreg.model.dto;

import com.codegans.arreg.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class TransferDto {
    private TransferType type;
    private String direction;
    private String reason;
    private String startDate;
    private String details;
    private String personId;
    private Integer vacationDays;
    private String clinic;
    private String diagnosis;
    private String location;

    public TransferDto(Transfer transfer) {
        this.direction = transfer.direction().name();
        this.reason = transfer.reason().name();
        this.startDate = transfer.startedAt().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public TransferDto(RegularTransfer transfer) {
        this((Transfer) transfer);
        this.type = TransferType.REGULAR;
    }

    public TransferDto(MedicalTransfer transfer) {
        this((Transfer) transfer);
        this.type = TransferType.MEDICAL;
        this.clinic = transfer.clinic();
        this.diagnosis = transfer.diagnosis();
        this.details = String.format("Clinic: %s, Diagnosis: %s", transfer.clinic(), transfer.diagnosis());
    }

    public TransferDto(VacationTransfer transfer) {
        this((Transfer) transfer);
        this.type = TransferType.VACATION;
        this.vacationDays = transfer.plannedDays();
        this.details = String.format("Planed for %d days", transfer.plannedDays());
    }

    public TransferDto(AssessmentTransfer transfer) {
        this((Transfer) transfer);
        this.type = TransferType.ASSESSMENT;
        this.location = transfer.location();
        this.details = String.format("Transferred to %s", transfer.location());
    }

}
