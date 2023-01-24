package com.codegans.arreg.ui;

import com.codegans.arreg.I18n;
import com.codegans.arreg.model.Person;
import com.codegans.arreg.ui.model.PersonRecord;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.UUID;

public class PersonList implements Renderable<TableView<PersonRecord>> {
    protected final TableView<PersonRecord> table;
    protected final TableColumn<PersonRecord, UUID> colId;
    protected final TableColumn<PersonRecord, String> colLastName;
    protected final TableColumn<PersonRecord, String> colFirstName;
    protected final TableColumn<PersonRecord, String> colMiddleName;
    private final List<PersonRecord> persons;

    public PersonList(List<Person> persons) {
        this.persons = persons.stream().map(PersonRecord::new).toList();

        this.table = new TableView<>(FXCollections.observableList(this.persons));
        this.colId = new TableColumn<>(I18n.LABEL_PERSON_ID.get());
        this.colLastName = new TableColumn<>(I18n.LABEL_PERSON_LAST_NAME.get());
        this.colFirstName = new TableColumn<>(I18n.LABEL_PERSON_FIRST_NAME.get());
        this.colMiddleName = new TableColumn<>(I18n.LABEL_PERSON_MIDDLE_NAME.get());
    }

    @Override
    public TableView<PersonRecord> render() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));

        table.setEditable(false);
        table.setPlaceholder(new Label(I18n.PROMPT_EMPTY.get()));
        table.getColumns().addAll(colId, colLastName, colFirstName, colMiddleName);

        return table;
    }
}
