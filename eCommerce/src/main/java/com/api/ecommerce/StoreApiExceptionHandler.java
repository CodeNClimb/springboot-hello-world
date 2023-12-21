package com.api.ecommerce;

import com.api.ecommerce.exceptions.CategoryNotUniqueException;
import com.api.ecommerce.exceptions.EntityNotFoundException;
import com.api.ecommerce.exceptions.ErrorResponse;
import com.api.ecommerce.exceptions.UsernameNotUniqueException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class StoreApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UsernameNotUniqueException.class)
    public ResponseEntity<Object> handleUsernameNotUniqueException(UsernameNotUniqueException ex) {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleCategoryNotUniqueException(CategoryNotUniqueException ex) {
        ErrorResponse error = new ErrorResponse(Collections.singletonList(ex.getLocalizedMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request)
         {
            List<String> errors = new ArrayList<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
            return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
}
