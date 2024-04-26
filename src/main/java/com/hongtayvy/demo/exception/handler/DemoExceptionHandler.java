package com.hongtayvy.demo.exception.handler;

import com.hongtayvy.demo.exception.DemoErrorResponse;
import com.hongtayvy.demo.exception.DemoFormatException;
import com.hongtayvy.demo.exception.DemoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DemoErrorResponse> handleException(DemoFormatException demoFormatException){
        DemoErrorResponse demoErrorResponse = new DemoErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                demoFormatException.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(demoErrorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler
    public ResponseEntity<DemoErrorResponse> handleException(DemoNotFoundException exception){
        DemoErrorResponse demoErrorResponse = new DemoErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(demoErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DemoErrorResponse> handleException(Exception exception){
        DemoErrorResponse demoErrorResponse = new DemoErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(demoErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
