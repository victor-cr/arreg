package com.codegans.arreg;

import java.util.ResourceBundle;

public enum I18n {
    LABEL_SEARCH("label.search"),
    LABEL_PERSON_ID("label.person.id"),
    LABEL_PERSON_LAST_NAME("label.person.lastName"),
    LABEL_PERSON_FIRST_NAME("label.person.firstName"),
    LABEL_PERSON_MIDDLE_NAME("label.person.middleName"),
    PROMPT_SEARCH("prompt.search"),
    PROMPT_EMPTY("prompt.empty"),

    RANK_PRIVATE("name.rank.private"),
    RANK_PRIVATE_FIRST_CLASS("name.rank.privateFirstClass"),
    RANK_JUNIOR_SERGEANT("name.rank.juniorSergeant"),
    RANK_SERGEANT("name.rank.sergeant"),
    RANK_SENIOR_SERGEANT("name.rank.seniorSergeant"),
    RANK_CHIEF_SERGEANT("name.rank.chiefSergeant"),
    RANK_STAFF_SERGEANT("name.rank.staffSergeant"),
    RANK_MASTER_SERGEANT("name.rank.masterSergeant"),
    RANK_SENIOR_MASTER_SERGEANT("name.rank.seniorMasterSergeant"),
    RANK_CHIEF_MASTER_SERGEANT("name.rank.chiefMasterSergeant"),
    RANK_JUNIOR_LIEUTENANT("name.rank.juniorLieutenant"),
    RANK_LIEUTENANT("name.rank.lieutenant"),
    RANK_SENIOR_LIEUTENANT("name.rank.seniorLieutenant"),
    RANK_CAPTAIN("name.rank.captain"),
    RANK_MAJOR("name.rank.major"),
    RANK_LIEUTENANT_COLONEL("name.rank.lieutenantColonel"),
    RANK_COLONEL("name.rank.colonel"),
    RANK_BRIGADIER_GENERAL("name.rank.brigadierGeneral"),
    RANK_MAJOR_GENERAL("name.rank.majorGeneral"),
    RANK_LIEUTENANT_GENERAL("name.rank.lieutenantGeneral"),
    RANK_GENERAL("name.rank.general");

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");
    private final String key;

    I18n(String key) {
        this.key = key;
    }

    public String get() {
        return BUNDLE.getString(key);
    }
}
