package com.codegans.arreg.service;

import com.codegans.arreg.model.BloodGroup;
import com.codegans.arreg.model.BloodRhD;
import com.codegans.arreg.model.Person;
import com.codegans.arreg.model.RegularTransfer;
import com.codegans.arreg.model.dto.FullPersonInfo;
import com.codegans.arreg.model.dto.MilitaryIDCardDto;
import com.codegans.arreg.model.dto.PersonDto;
import com.codegans.arreg.model.dto.TransferDto;
import com.codegans.arreg.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonnelService {
    private final PersonRepository personRepository;

    public List<PersonDto> getAllPersonnel() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false).map(PersonDto::new).toList();
    }

    public FullPersonInfo getById(String id) {
        Person person = personRepository.findById(UUID.fromString(id)).orElse(null);
        return person != null
                ? new FullPersonInfo(new PersonDto(person), new MilitaryIDCardDto(person.militaryIdentityCard()), convertTransfers(person))
                : null;
    }

    private List<TransferDto> convertTransfers(Person person) {
//        return Stream.of(person.regularTransfers(), person.medicalTransfers(), person.vacationTransfers(), person.assessmentTransfers())
//                .flatMap(List::stream)
//                .map(TransferDto::new)
//                .sorted(Comparator.comparing(TransferDto::getStartDate).reversed())
//                .toList();
        TransferDto transfer1 = new TransferDto();
        transfer1.setDirection("OUT");
        transfer1.setType("Regular");
        transfer1.setReason("TRANSFER_REGULAR");
        transfer1.setStartDate("2023-05-02");

        TransferDto transfer2 = new TransferDto();
        transfer2.setDirection("OUT");
        transfer2.setType("Medical");
        transfer2.setReason("MEDICAL_TREATMENT");
        transfer2.setStartDate("2022-11-24");
        transfer2.setDetails("Clinic: Dobrobut, Diagnosis: broken leg");

        return Stream.of(transfer1, transfer2).sorted(Comparator.comparing(TransferDto::getStartDate).reversed()).toList();

    }

    public void savePerson(PersonDto personDto) {
        Person person = new Person(personDto.getLastName(), personDto.getFirstName(),
                personDto.getMiddleName(), LocalDate.parse(personDto.getBirthDate(), DateTimeFormatter.ISO_LOCAL_DATE),
                personDto.getBirthPlace(), personDto.getItn(),
                BloodGroup.valueOf(personDto.getBloodGroup()), BloodRhD.valueOf(personDto.getBloodRhD()));
        personRepository.save(person);
    }
}
