package com.codegans.arreg.service;

import com.codegans.arreg.model.BloodGroup;
import com.codegans.arreg.model.BloodRhD;
import com.codegans.arreg.model.Person;
import com.codegans.arreg.model.dto.PersonDto;
import com.codegans.arreg.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PersonnelService {
    private final PersonRepository personRepository;

    public List<PersonDto> getAllPersonnel() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false).map(PersonDto::new).toList();
    }

    public PersonDto getById(String id) {
        Person person = personRepository.findById(UUID.fromString(id)).orElse(null);
        return person != null ? new PersonDto(person) : null;
    }

    public void savePerson(PersonDto personDto) {
        Person person = new Person(personDto.getLastName(), personDto.getFirstName(),
                personDto.getMiddleName(), LocalDate.parse(personDto.getBirthDate(), DateTimeFormatter.ISO_LOCAL_DATE),
                personDto.getBirthPlace(), personDto.getItn(),
                BloodGroup.valueOf(personDto.getBloodGroup()), BloodRhD.valueOf(personDto.getBloodRhD()));
        personRepository.save(person);
    }
}
