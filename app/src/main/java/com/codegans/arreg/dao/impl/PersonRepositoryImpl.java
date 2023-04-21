package com.codegans.arreg.dao.impl;

import com.codegans.arreg.dao.PersonRepository;
import com.codegans.arreg.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Java doc here
 *
 * @author Sniesariev Vitalii
 * @since 21/04/2023
 */
public class PersonRepositoryImpl implements PersonRepository {
    private JdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Person person) {
        String sql = "insert into PERSON(ID,LAST_NAME,FIRST_NAME,MIDDLE_NAME,BIRTH_DATE,BIRTH_PLACE,ITN,BLOOD_GROUP,BLOOD_RHD) " +
                "values (?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, person.id(), person.lastName(), person.firstName(), person.middleName(), person.birthDate(), person.birthPlace(), person.itn(), person.bloodGroup(), person.bloodRhD());

    }
}
