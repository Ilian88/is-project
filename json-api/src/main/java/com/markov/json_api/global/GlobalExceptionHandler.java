package com.markov.json_api.global;

import com.markov.json_api.error.RecordExistsException;
import com.markov.json_api.error.RequestExistsErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordExistsException.class)
    public ResponseEntity<?> handleRecordExistsException(RecordExistsException exception) {
        return ResponseEntity.badRequest().body(new RequestExistsErrorMessage(
                exception.getMessage(),
                "409"
        ));
    }
}
