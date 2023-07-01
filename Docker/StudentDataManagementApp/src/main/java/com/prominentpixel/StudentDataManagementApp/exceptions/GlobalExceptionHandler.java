package com.prominentpixel.StudentDataManagementApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoStudentException.class)
    public ResponseEntity<Object> studentException(NoStudentException studentException){
        return new ResponseEntity<>(studentException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception exception){
        return new ResponseEntity<>("Your input is invalid",HttpStatus.BAD_REQUEST);
    }


}
