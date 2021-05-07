package com.monman.login.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({LoginException.class})
    @ResponseBody
    protected ResponseEntity<Object> handleConflict(LoginException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }
}
