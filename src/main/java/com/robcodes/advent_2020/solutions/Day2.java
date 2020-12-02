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
                Objects.requireNonNull(Day2.class.getClassLoader().getResourceAsStream("input//day2-pt1.txt")),
                StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            int part1Counter = 0;
            int part2Counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] passwordAndPasswordRules = line.split(":");
                String[] passwordRules = passwordAndPasswordRules[0].split(" ");
                String[] range = passwordRules[0].split("-");
                String regex = passwordRules[1];
                int i = 0;
                //Part 1
                Matcher matcher = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(passwordAndPasswordRules[1]);
                while (matcher.find()) {
                    i++;
                }
                int range1 = Integer.parseInt(range[0]);
                int range2 = Integer.parseInt(range[1]);
                if (i >= range1 && i <= range2) {
                    part1Counter++;
                }
                //Part 2
                char c1 = passwordAndPasswordRules[1].charAt(range1);
                char c2 = passwordAndPasswordRules[1].charAt(range2);
                if (c1 == regex.charAt(0) ^ c2 == regex.charAt(0)) {
                    part2Counter++;
                }
            }
            System.out.println("Day 2 Part 1 Answer " + part1Counter);
            System.out.println("Day 2 Part 2 Answer " + part2Counter);
        }
    }
}