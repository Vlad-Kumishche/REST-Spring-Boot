package javalearning.restapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidRequestParamsException extends RuntimeException {
    public String getMessage() {
        return "Invalid RequestParams. HttpStatus: BAD_REQUEST";
    }
}
