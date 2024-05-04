package com.java.practice;

import java.time.LocalDate;

public class CheckEndOfMonthMinusOneDay {

    public static void main(String[] args) {
        boolean isEndOfMonthMinusOneDay = checkIfEndOfMonthMinusOneDay();

        if (isEndOfMonthMinusOneDay) {
            System.out.println("Current date is the end of the month minus one day.");
        } else {
            System.out.println("Current date is not the end of the month minus one day.");
        }
    }

    private static boolean checkIfEndOfMonthMinusOneDay() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endOfMonthMinusOneDay = currentDate.withMonth(currentDate.getMonthValue())
        		.withDayOfMonth(currentDate.lengthOfMonth()).minusDays(1);
        
        System.out.println("Current Date: " +currentDate);
        System.out.println("End Of Month Minus One day: " +endOfMonthMinusOneDay);
//        System.out.println("Custom Day: " +customDay);

        return currentDate.equals(endOfMonthMinusOneDay);
    }
}
