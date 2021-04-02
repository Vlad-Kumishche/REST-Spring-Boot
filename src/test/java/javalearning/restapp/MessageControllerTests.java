package javalearning.restapp;

import javalearning.restapp.controller.MessageController;
import javalearning.restapp.exceptions.InvalidRequestParamsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

public class MessageControllerTests {

    @Test
    void numberOfOccurrences_ValidResults() {
        Map<String, String> response = new HashMap<>();
        response.put("numberOfOccurrences", "2");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        Assertions.assertEquals(new ResponseEntity<>(response, responseHeaders, HttpStatus.OK), MessageController.numberOfOccurrences("qwerty qwerty", "q"));
    }

    @Test
    void numberOfOccurrences_InvalidRequestParamsException_EmptyWord() throws InvalidRequestParamsException {
        Throwable thrown = assertThrows(InvalidRequestParamsException.class, () -> MessageController.numberOfOccurrences("", "a"));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void numberOfOccurrences_InvalidRequestParamsException_EmptySign() throws InvalidRequestParamsException {
        Throwable thrown = assertThrows(InvalidRequestParamsException.class, () -> MessageController.numberOfOccurrences("Hello World", ""));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void numberOfOccurrences_InvalidRequestParamsException_SignAndWordBothEmpty() throws InvalidRequestParamsException {
        Throwable thrown = assertThrows(InvalidRequestParamsException.class, () -> MessageController.numberOfOccurrences("", ""));
        assertNotNull(thrown.getMessage());
    }

    @Test
    void numberOfOccurrences_InvalidRequestParamsException_SignLengthMoreThanOne() throws InvalidRequestParamsException {
        Throwable thrown = assertThrows(InvalidRequestParamsException.class, () -> MessageController.numberOfOccurrences("Hello World", "He"));
        assertNotNull(thrown.getMessage());
    }
}
