package javalearning.restapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidRequestParamsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Invalid RequestParams. HttpStatus: INTERNAL_SERVER_ERROR";
    }
}
