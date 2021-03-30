package javalearning.restapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {
    @GetMapping("/numberOfOccurrences")
    public ResponseEntity<Map<String, String>> numberOfOccurrences(@RequestParam("word") String word, @RequestParam("sign") String sign) {
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
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }
}
