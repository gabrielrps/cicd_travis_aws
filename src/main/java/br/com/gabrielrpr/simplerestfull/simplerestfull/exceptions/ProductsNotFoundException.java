package br.com.gabrielrpr.simplerestfull.simplerestfull.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductsNotFoundException extends RuntimeException{

    public ProductsNotFoundException(String message) {
        super(message);
    }

    public ProductsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
