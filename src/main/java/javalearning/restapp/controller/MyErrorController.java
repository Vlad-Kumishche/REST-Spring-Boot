package javalearning.restapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public Map<String, String> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String message = switch (statusCode) {
            case 400 -> "Bad request";
            case 500 -> "Internal server error";
            default -> null;
        };

        Map<String, String> response = new HashMap<>();
        response.put("error", "true");
        response.put("statusCode", String.valueOf(statusCode));
        if (message != null) {
            response.put("message", message);
        }

        return response;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}