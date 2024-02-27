package com.Student.exception;
import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends RuntimeException  {
    public ResourceNotFoundException(){
        super("resource not found with this given StudentId");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }


}
