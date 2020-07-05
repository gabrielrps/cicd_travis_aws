package br.com.gabrielrpr.simplerestfull.simplerestfull.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private final String message;
    private final ZonedDateTime zonedDateTime;



}
