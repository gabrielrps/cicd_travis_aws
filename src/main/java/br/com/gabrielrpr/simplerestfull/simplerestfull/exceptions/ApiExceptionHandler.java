package br.com.gabrielrpr.simplerestfull.simplerestfull.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ProductsNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleProductNotFound(ProductsNotFoundException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
