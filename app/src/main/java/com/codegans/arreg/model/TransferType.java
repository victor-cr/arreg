package com.codegans.arreg.model;

import lombok.Getter;

@Getter
public enum TransferType {
    REGULAR("Regular"),
    MEDICAL("Medical"),
    VACATION("Vacation"),
    ASSESSMENT("Assessment");

    private final String desc;

    TransferType(String desc) {
        this.desc = desc;
    }
}
