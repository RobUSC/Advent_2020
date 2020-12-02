package com.robcodes.advent_2020.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {

    public static void main(String[] args) throws IOException {
        try (InputStreamReader streamReader = new InputStreamReader(
                Objects.requireNonNull(Day2.class.getClassLoader().getResourceAsStream("input//day2.txt")),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] passwordAndPasswordRules = line.split(":");
                String[] passwordRules = passwordAndPasswordRules[0].split(" ");
                String[] range = passwordRules[0].split("-");
                String regex = passwordRules[1];
                int i = 0;
                Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(passwordAndPasswordRules[1]);
                while (matcher.find()) {
                    i++;
                }
                if (i >= Long.parseLong(range[0]) && i <= Long.parseLong(range[1])) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}