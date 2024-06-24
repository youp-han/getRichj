package com.jjst.getRich.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Utility {


    public static LocalDate stringToTime(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Check if the string contains 'T' and trim time part if present
        if (s.contains("T")) {
            s = s.substring(0, s.indexOf('T'));
        }

        String date = s.trim(); // Trim any leading/trailing whitespace

        // Parse the date string into LocalDateTime using the formatter
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            // Handle the exception (e.g., log error, throw custom exception, etc.)
            System.err.println("Error parsing date string: " + s);
            throw e; // Optionally rethrow or handle differently based on your requirement
        }
    }

    public static long dateDiffFromToday(LocalDate date){
        return ChronoUnit.DAYS.between(date, LocalDate.now());
    }
}