package com.codegans.arreg.service;

import com.codegans.arreg.model.*;
import com.codegans.arreg.model.dto.TransferDto;
import com.codegans.arreg.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final PersonRepository personRepository;

    public void save(TransferDto transferDto) {
        Person person = personRepository.findById(UUID.fromString(transferDto.getPersonId())).orElse(null);
        if (person == null) {
            return;
        }
        switch (transferDto.getType()){
            case REGULAR -> person.regularTransfers().add(createRegularTransfer(transferDto, person));
            case MEDICAL -> person.medicalTransfers().add(createMedicalTransfer(transferDto, person));
            case VACATION -> person.vacationTransfers().add(createVacationTransfer(transferDto, person));
            case ASSESSMENT -> person.assessmentTransfers().add(createAssessmentTransfer(transferDto, person));
        }
        personRepository.save(person);
    }

    private RegularTransfer createRegularTransfer(TransferDto transferDto, Person person) {
        return new RegularTransfer(
                Direction.valueOf(transferDto.getDirection()),
                Reason.valueOf(transferDto.getReason()),
                LocalDate.parse(transferDto.getStartDate()),
                person);
    }

    private MedicalTransfer createMedicalTransfer(TransferDto transferDto, Person person) {
        return new MedicalTransfer(
                Direction.valueOf(transferDto.getDirection()),
                Reason.valueOf(transferDto.getReason()),
                LocalDate.parse(transferDto.getStartDate()),
                transferDto.getClinic(),
                transferDto.getDiagnosis(),
                person);
    }

    private VacationTransfer createVacationTransfer(TransferDto transferDto, Person person) {
        return new VacationTransfer(
                Direction.valueOf(transferDto.getDirection()),
                Reason.valueOf(transferDto.getReason()),
                LocalDate.parse(transferDto.getStartDate()),
                person,
                transferDto.getVacationDays());
    }

    private AssessmentTransfer createAssessmentTransfer(TransferDto transferDto, Person person) {
        return new AssessmentTransfer(
                Direction.valueOf(transferDto.getDirection()),
                Reason.valueOf(transferDto.getReason()),
                LocalDate.parse(transferDto.getStartDate()),
                transferDto.getLocation(),
                person);
    }


}
