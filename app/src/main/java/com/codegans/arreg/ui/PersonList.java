package com.codegans.arreg.ui;

import com.codegans.arreg.model.Person;
import javafx.scene.Scene;

import java.util.List;

public class PersonList {
    private final Scene scene;
    private final List<Person> persons;

    public PersonList(Scene scene, List<Person> persons) {
        this.scene = scene;
        this.persons = persons;
    }

    public void apply() {

    }
}
