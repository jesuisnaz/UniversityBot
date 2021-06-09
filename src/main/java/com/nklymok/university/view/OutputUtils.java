package com.nklymok.university.view;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutputUtils {

    public void printString(String s) {
        System.out.println(s);
    }

    public void printJoined(List<String> strings, String delim) {
        String result = strings.stream().collect(Collectors.joining(delim));
        printString(result);
    }

}
