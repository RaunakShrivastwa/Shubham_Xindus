package com.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> getExceptionHandler(ResourceNotFoundException ex){
        String messaage=ex.getMessage();
        ApiResponce responce = ApiResponce.builder().message(messaage).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponce>(responce,HttpStatus.NOT_FOUND);
    }

}
