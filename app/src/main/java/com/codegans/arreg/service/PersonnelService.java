package com.codegans.arreg.service;

import com.codegans.arreg.model.BloodGroup;
import com.codegans.arreg.model.BloodRhD;
import com.codegans.arreg.model.Person;
import com.codegans.arreg.model.dto.FullPersonInfo;
import com.codegans.arreg.model.dto.MilitaryIDCardDto;
import com.codegans.arreg.model.dto.PersonDto;
import com.codegans.arreg.model.dto.TransferDto;
import com.codegans.arreg.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonnelService {
    private final PersonRepository personRepository;

    public List<PersonDto> getAllPersonnel() {
        return personRepository.findAll().stream().map(PersonDto::new).toList();
    }

    public PersonDto getById(String id) {
        Person person = personRepository.findById(UUID.fromString(id)).orElse(null);
        return person == null ? null : new PersonDto(person);
    }

    public FullPersonInfo getByIdFullInfo(String id) {
        Person person = personRepository.findById(UUID.fromString(id)).orElse(null);
        if (person == null) {
            return new FullPersonInfo();
        }

        MilitaryIDCardDto militaryIDCardDto =
                person.militaryIdentityCard() == null
                        ? new MilitaryIDCardDto()
                        : new MilitaryIDCardDto(person.militaryIdentityCard());

        return new FullPersonInfo(new PersonDto(person), militaryIDCardDto, convertTransfers(person));
    }

    private List<TransferDto> convertTransfers(Person person) {
        List<TransferDto> transfers = new ArrayList<>();
        transfers.addAll(person.regularTransfers().stream().map(TransferDto::new).toList());
        transfers.addAll(person.medicalTransfers().stream().map(TransferDto::new).toList());
        transfers.addAll(person.vacationTransfers().stream().map(TransferDto::new).toList());
        transfers.addAll(person.assessmentTransfers().stream().map(TransferDto::new).toList());

        return transfers.stream()
                .sorted(Comparator.comparing(TransferDto::getStartDate).reversed())
                .toList();
    }

    public void savePerson(PersonDto personDto) {
        Person person = new Person(personDto.getLastName(), personDto.getFirstName(),
                personDto.getMiddleName(), LocalDate.parse(personDto.getBirthDate(), DateTimeFormatter.ISO_LOCAL_DATE),
                personDto.getBirthPlace(), personDto.getItn(),
                BloodGroup.valueOf(personDto.getBloodGroup()), BloodRhD.valueOf(personDto.getBloodRhD()));
        personRepository.save(person);
    }
}
