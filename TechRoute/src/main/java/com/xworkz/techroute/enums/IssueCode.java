package com.xworkz.techroute.enums;

import lombok.Getter;

@Getter
public enum IssueCode {
    // ✅ General success
    OK("Operation successful"),

    // ✅ Database / persistence
    DB_ERROR("Database error occurred"),
    NULL_ERROR("Null value encountered"),
    INVALID_IDENTIFIER("Invalid identifier provided"),

    // ✅ Validation errors
    INVALID("Invalid input"),
    INVALID_QUANTITY("Quantity is invalid"),
    INSUFFICIENT_STOCK("Not enough stock available"),

    USER("USER"),
    ADMIN("ADMIN"),
    // ✅ Product / stock domain
    PRODUCT_NOT_FOUND("Product not found"),
    STOCK_NOT_FOUND("Stock record not found"),

    // ✅ User / account domain
    USER_NOT_FOUND("User not found"),
    NAME_EXIST("Name already exists"),
    EMAIL_EXIST("Email already exists"),
    PHONE_EXIST("Phone number already exists"),
    NO_EMAIL("Email not provided"),
    NO_PHONE_NUMBER("Phone number not provided"),
    INVALID_PASSWORD("Invalid password"),
    PASSWORD_MISMATCH("Passwords do not match"),
    ACCOUNT_LOCKED("Account is locked"),

    // ✅ Communication / messaging
    SEND_ERROR("Error sending message");

    private final String message;

    IssueCode(String message) {
        this.message = message;
    }
}
