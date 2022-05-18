package com.alfred.hellospringwebapp.api;

import com.alfred.hellospringwebapp.exception.ApplicationError;
import com.alfred.hellospringwebapp.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.Entity;

@ControllerAdvice
@RestController
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> hundleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest webRequest) {
        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setDetail(details);
        error.setMessage(exception.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
