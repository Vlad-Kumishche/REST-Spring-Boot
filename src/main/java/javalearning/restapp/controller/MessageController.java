package javalearning.restapp.controller;

import javalearning.restapp.exceptions.EmptyRequestParamsException;
import javalearning.restapp.exceptions.InvalidRequestParamsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {
    @GetMapping("/numberOfOccurrences")
    public static ResponseEntity<Map<String, String>> numberOfOccurrences(@RequestParam(name = "word", required = false, defaultValue = "") String word, @RequestParam(name = "sign", required = false, defaultValue = "") String sign) {
        if (word.equals("") || sign.equals(""))
        {
            myLogger.error("Empty RequestParams");
            throw new EmptyRequestParamsException();
        }

        if (sign.length() > 1)
        {
            myLogger.error("Invalid sign");
            throw new InvalidRequestParamsException();
        }

        int numberOfOccurrences = 0;
        for (int i = 0; i < word.length(); i++)
        {
            if (sign.charAt(0) == word.charAt(i))
            {
                numberOfOccurrences++;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("numberOfOccurrences", String.valueOf(numberOfOccurrences));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        myLogger.info("Response: numberOfOccurrences = " + numberOfOccurrences);

        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    private static final Logger myLogger = LogManager.getLogger(MessageController.class);
}
