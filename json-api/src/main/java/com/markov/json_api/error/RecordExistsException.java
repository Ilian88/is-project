package com.markov.json_api.error;

public class RecordExistsException extends Exception {
    public RecordExistsException(String message) {
        super(message);
    }
}
