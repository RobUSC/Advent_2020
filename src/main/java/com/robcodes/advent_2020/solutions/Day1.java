package com.robcodes.advent_2020.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws IOException {
        try (InputStreamReader streamReader = new InputStreamReader(
                Objects.requireNonNull(Day1.class.getClassLoader().getResourceAsStream("input//day1-pt1.txt")),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            Map<Long, Long> part1InputMap = new HashMap<>();
            List<Long> part2InputList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                long l = Long.parseLong(line);
                part1InputMap.put(2020L - l, l);
                //Part 1
                if (part1InputMap.get(l) != null) {
                    System.out.println("Day 1 Part 1 Answer: " + part1InputMap.get(l) * l);
                }
                //Part 2 Naive
                part2InputList.add(l);
            }
            //Part 2 Naive
            part2InputList.forEach(aLong -> {
                part2InputList.forEach(aLong1 -> {
                    part2InputList.forEach(aLong2 -> {
                        if (aLong + aLong1 + aLong2 == 2020) {
                            System.out.println("Day 1 Part 2 Answer: " + aLong * aLong1 * aLong2);
                            System.exit(0);
                        }
                    });
                });
            });
        }
    }
}
