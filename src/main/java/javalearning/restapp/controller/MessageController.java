package javalearning.restapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    @GetMapping
    public ResponseEntity<Map<String, String>> guessTheNumber(@RequestParam("currentNumber") int currentNumber) {
        int randomNumber = (int) ((Math.random() * 99) + 1);
        String result;
        if (currentNumber < randomNumber)
        {
            result = "Current number is less than random number";
        }
        else if (currentNumber > randomNumber)
        {
            result = "Current number is greater than random number";
        }
        else
        {
            result = "Current number is equals to random number";
        }

        Map<String, String> response = new HashMap<>();
        response.put("currentNumber", String.valueOf(currentNumber));
        response.put("randomNumber", String.valueOf(randomNumber));
        response.put("result", result);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
}
