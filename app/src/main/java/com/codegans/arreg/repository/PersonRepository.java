package com.codegans.arreg.repository;

import com.codegans.arreg.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

/**
 * Java doc here
 *
 * @author Sniesariev Vitalii
 * @since 21/04/2023
 */
public interface PersonRepository extends JpaRepository<Person, UUID> {

    @Query("SELECT p FROM Person p WHERE p.itn = :itn")
    Person findByItn(String itn);
}
