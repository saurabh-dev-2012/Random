package com.java.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDataValidator {

    public static void main(String[] args) {
        String filePath = "DataValidation.txt";
        Path path = Paths.get(filePath);
        System.out.println(path.toAbsolutePath());

        try {
            Files.lines(path)
                    .forEach(FileDataValidator::validateData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateData(String data) {
        // Validate date format (YYYY-MM-DD)
    	
    	String[] split = data.split("-");
        if (isValidDateFormat(split[0].trim())) {
            System.out.println("Date format is valid: " + split[0].trim());
        } else {
            System.out.println("Invalid date format: " + split[0].trim());
        }

        // Validate alphanumeric content
        if (isValidAlphanumeric(split[1].trim())) {
            System.out.println("Alphanumeric content is valid: " + split[1].trim());
        } else {
            System.out.println("Invalid alphanumeric content: " + split[1].trim());
        }

        // Validate amount format (digits with optional decimal part)
        if (isValidAmountFormat(split[2].trim())) {
            System.out.println("Amount format is valid: " + split[2].trim());
        } else {
            System.out.println("Invalid amount format: " + split[2].trim());
        }

        // Add more validation as needed...
    }

    private static boolean isValidDateFormat(String input) {
        // Example date format (YYYY-MM-DD)
        String dateFormatRegex = "\\d{2}/\\d{2}/\\d{4}";
        return input.matches(dateFormatRegex);
    }

    private static boolean isValidAlphanumeric(String input) {
        // Example: Alphanumeric content (letters and digits)
        String alphanumericRegex = "^[a-zA-Z0-9]+$";
        return input.matches(alphanumericRegex);
    }

    private static boolean isValidAmountFormat(String input) {
        // Example amount format (digits with optional decimal part)
        String amountFormatRegex = "\\d+(\\.\\d+)?";
        return input.matches(amountFormatRegex);
    }
}

