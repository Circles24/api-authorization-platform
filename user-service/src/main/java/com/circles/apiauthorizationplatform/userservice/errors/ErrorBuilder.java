package com.circles.apiauthorizationplatform.userservice.errors;

import java.sql.Timestamp;
import java.util.UUID;


public enum ErrorBuilder {
    user_not_found("user not found", 404, "user_not_found", "000-001"),
    internal_server_error("something went wrong", 500, "internal_server_error", "000-002"),
    identity_not_found("identity not found", 404, "identity_not_found", "000-003"),
    attribute_not_found("attribute not found", 404, "attribute_not_found", "000-004"),
    meta_attribute_not_found("meta attribute not found", 404, "meta_attribute_not_found", "000-005")
            ;

    private final String message;
    private final int statusCode;
    private final String errorName;
    private final String errorCode;

    public Error build() {
        String uuid = UUID.randomUUID().toString();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return Error.builder().id(uuid).message(message).statusCode(statusCode).errorName(errorName).errorCode(errorCode).source("user-service").timestamp(timestamp).build();
    }

    ErrorBuilder(String message, int statusCode, String errorName, String errorCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorName = errorName;
        this.errorCode = errorCode;
    }
}
