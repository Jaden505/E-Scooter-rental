package com.app.esserver.exceptions;

public class PreConditionFailed extends RuntimeException {
    public PreConditionFailed(String message) {
        super(message);
    }
}
