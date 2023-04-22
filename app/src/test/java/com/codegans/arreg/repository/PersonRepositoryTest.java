package com.codegans.arreg.repository;

import com.codegans.arreg.model.BloodGroup;
import com.codegans.arreg.model.BloodRhD;
import com.codegans.arreg.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java doc here
 *
 * @author Sniesariev Vitalii
 * @since 22/04/2023
 */
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository repository;
    @Test
    void testAddPersons(){
        repository.save(new Person("Surname", "Name", "MiddleName", LocalDate.of(1979, 7, 7), "Kherson", "2121345643", BloodGroup.A, BloodRhD.POSITIVE));
        repository.save(new Person("Othersurname", "Othername", "MiddleName", LocalDate.of(1993, 3, 23), "Kyiv", "6343214531", BloodGroup.AB, BloodRhD.NULL));

        Iterable<Person> persons = repository.findAll();
        assertEquals(2, StreamSupport.stream(persons.spliterator(),false).count());
    }

}