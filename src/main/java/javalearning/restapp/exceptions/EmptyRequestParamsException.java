package javalearning.restapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmptyRequestParamsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Invalid RequestParams. HttpStatus: BAD_REQUEST";
    }
}