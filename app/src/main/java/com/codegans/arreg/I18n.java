package com.codegans.arreg;

import java.util.ResourceBundle;

public enum I18n {
    LABEL_SEARCH("label.search"),
    LABEL_PERSON_ID("label.person.id"),
    LABEL_PERSON_LAST_NAME("label.person.lastName"),
    LABEL_PERSON_FIRST_NAME("label.person.firstName"),
    LABEL_PERSON_MIDDLE_NAME("label.person.middleName"),
    PROMPT_SEARCH("prompt.search"),
    PROMPT_EMPTY("prompt.empty");

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");
    private final String key;

    I18n(String key) {
        this.key = key;
    }

    public String get() {
        return BUNDLE.getString(key);
    }
}
