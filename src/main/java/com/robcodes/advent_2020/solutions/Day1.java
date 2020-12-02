package com.robcodes.advent_2020.solutions;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day1 {

    public static void main(String[] args) throws IOException {
        try (InputStreamReader streamReader = new InputStreamReader(
                Objects.requireNonNull(Day1.class.getClassLoader().getResourceAsStream("input//day1-pt1.txt")),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            Map<Long, Long> inputMap = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                long l = Long.parseLong(line);
                inputMap.put(2020L - l, l);
                //Part 1
                if (inputMap.get(l) != null) {
                    System.out.println("Day 1 Part 1 Answer: " + inputMap.get(l) * l);
                }
            }
        }
        //Part 2

    }
}
