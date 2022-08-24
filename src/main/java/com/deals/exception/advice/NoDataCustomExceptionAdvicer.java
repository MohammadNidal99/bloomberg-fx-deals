package com.deals.exception.advice;

import com.deals.exception.NoDataCustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoDataCustomExceptionAdvicer {

    @ExceptionHandler(NoDataCustomException.class)
    public ResponseEntity<String> handleNoDataCustomException(NoDataCustomException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }


}
