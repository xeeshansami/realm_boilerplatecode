package com.hbl.vlinkapp.realmDB.model;

public enum QuestionTypeDB {
    TEXT_INPUT(1),
    RATINGS(2),
    SINGLE_RADIO_BUTTONS(3),
    MULTIPLE_BUTTONS(4),
    DROP_DOWN(5),
    SINGLE_CHECKBOX_BUTTONS(6);
    int value;
    QuestionTypeDB(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
