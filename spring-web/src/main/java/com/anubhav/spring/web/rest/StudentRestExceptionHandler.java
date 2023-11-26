package com.anubhav.spring.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // Creating a new error response
        StudentErrorResponse err = new StudentErrorResponse();

        // set the timestamp for error response
        err.setTimestamp(System.currentTimeMillis());

        // check if the exception is StudentNotFoundException
        if(exc.getClass() == StudentNotFoundException.class){
            // set the status code and message
            err.setStatus(HttpStatus.NOT_FOUND.value());
            err.setMessage(exc.getMessage());
            return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
        }

        // the exception is some other exception
        // set the status code and message
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Bad Request . Please make sure the ID is an integer");
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

}
