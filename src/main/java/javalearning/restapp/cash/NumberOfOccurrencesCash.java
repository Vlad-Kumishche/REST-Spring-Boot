package javalearning.restapp.cash;

import javalearning.restapp.data.RequestParams;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NumberOfOccurrencesCash {
    private final HashMap<RequestParams, Integer> hashMap = new HashMap<>();

    public boolean isContain(RequestParams key) {
        return hashMap.containsKey(key);
    }

    public void add(RequestParams key, Integer result) {
        hashMap.put(key, result);
    }

    public Integer getResult(RequestParams key) {
        return hashMap.get(key);
    }
}
