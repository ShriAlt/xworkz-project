package com.xworkz.techRoute.enums;

public enum IssueCode {
    DB_ERROR("error in db"),
    INVALID("error in db"),
    NO_EMAIL("error in db"),
    PASSWORD_MISMATCH("error in db"),
    USER("error in db"),
    ADMIN("error in db"),
    ACCOUNT_LOCKED("error in db"),
    NO_PHONE_NUMBER("error in db"),
    SEND_ERROR("error in db"),
    INVALID_IDENTIFIER("error in db"),
    NULL_ERROR("null error"),
    INVALID_PASSWORD("null error"),
    OK("everything is fine"),
    EMAIL_EXIST("everything is fine"),
    PHONE_EXIST("everything is fine");

    private final String messages;
    IssueCode(String messages){
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }
}
