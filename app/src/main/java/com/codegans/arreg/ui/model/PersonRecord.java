package com.codegans.arreg.ui.model;

import com.codegans.arreg.model.Person;
import javafx.beans.property.SimpleStringProperty;

import java.util.UUID;

public class PersonRecord {
    private SimpleStringProperty id;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleStringProperty middleName;

    public PersonRecord() {
    }

    public PersonRecord(Person person) {
        this.id = new SimpleStringProperty(person.id().toString());
        this.lastName = new SimpleStringProperty(person.lastName());
        this.firstName = new SimpleStringProperty(person.firstName());
        this.middleName = new SimpleStringProperty(person.middleName());
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public SimpleStringProperty middleNameProperty() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }
}
