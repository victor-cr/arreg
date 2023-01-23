package com.codegans.arreg;

import java.util.ResourceBundle;

public enum I18n {
    LABEL_SEARCH("label.search"),
    PROMPT_SEARCH("prompt.search");

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");
    private final String key;

    I18n(String key) {
        this.key = key;
    }

    public String get() {
        return BUNDLE.getString(key);
    }
}
