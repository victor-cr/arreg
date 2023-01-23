package com.codegans.arreg.ui;

import com.codegans.arreg.I18n;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonFilter implements Renderable<GridPane> {
    protected final GridPane layout;
    protected final TextField inpSearch;
    protected final Button btnSearch;

    public PersonFilter() {
        this.layout = new GridPane();
        this.inpSearch = new TextField();
        this.btnSearch = new Button(I18n.LABEL_SEARCH.get());
    }

    @Override
    public GridPane render() {
        inpSearch.setPromptText(I18n.PROMPT_SEARCH.get());

        btnSearch.setDefaultButton(true);

        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(25, 25, 25, 25));
        layout.add(inpSearch, 0, 0);
        layout.add(btnSearch, 1, 0);

        return layout;
    }
}
