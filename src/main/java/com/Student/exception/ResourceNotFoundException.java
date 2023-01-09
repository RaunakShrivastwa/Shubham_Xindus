package com.Student.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ResourceNotFoundException extends RuntimeException  {
    public ResourceNotFoundException(){
        super("resource not found with this given StudentId");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }


}
