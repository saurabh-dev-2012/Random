package com.java.practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/*********
 * 
 * @author saurabh
 *
 *
 *
 * Problem:    
 * Calculate the sum of amounts for all the given list of dates (A). If for a particular
date amount is not given, take the previous available date value and substitute it.
A: 06/02/2023, 06/03/2023, 06/06/2023, 06/07/2023, 06/14/2023, 06/19/2023,
06/23/2023, 06/24/2023
B:
06/02/2023 - 0.34567
06/06./2023 - 0.18244
06/07/2023 - 1.60006
06/14/2023 - 2.50010
06/23/2023 - 0.24
06/24/2023 - 0.00101

 */

public class SumOfAmounts {
    public static void main(String[] args) {
        Map<LocalDate, Double> dateAmountMap = new HashMap<>();

        // Populate the map with provided amounts
        dateAmountMap.put(LocalDate.of(2023, 6, 2), 0.34567);
        dateAmountMap.put(LocalDate.of(2023, 6, 6), 0.18244);
        dateAmountMap.put(LocalDate.of(2023, 6, 7), 1.60006);
        dateAmountMap.put(LocalDate.of(2023, 6, 14), 2.50010);
        dateAmountMap.put(LocalDate.of(2023, 6, 23), 0.24);
        dateAmountMap.put(LocalDate.of(2023, 6, 24), 0.00101);

        // Given list of dates (A)
        LocalDate[] datesA = {
            LocalDate.of(2023, 6, 2),
            LocalDate.of(2023, 6, 3),
            LocalDate.of(2023, 6, 6),
            LocalDate.of(2023, 6, 7),
            LocalDate.of(2023, 6, 14),
            LocalDate.of(2023, 6, 19),
            LocalDate.of(2023, 6, 23),
            LocalDate.of(2023, 6, 24)
        };

        // Calculate the sum of amounts
        double sumOfAmounts = calculateSumOfAmounts(dateAmountMap, datesA);

        System.out.println("Sum of amounts: " + sumOfAmounts);
    }

    private static double calculateSumOfAmounts(Map<LocalDate, Double> dateAmountMap, LocalDate[] dates) {
        double sum = 0.0;
        Double previousAmount = null;

        for (LocalDate date : dates) {
            // Check if the map contains the given date
        	if(isBusinessDay(date) && !isHoliday(date)) {
        		if (dateAmountMap.containsKey(date)) {
                    double amount = dateAmountMap.get(date);
                    sum += amount;
                    previousAmount = amount; // Update previousAmount for future substitutions
                } else {
                    // If the date is not found, use the previous available amount
                    if (previousAmount != null) {
                        sum += previousAmount;
                    }
                    // If there is no previous amount, it remains 0
                }
        	}
        }

        return sum;
    }
    
    private static boolean isBusinessDay(LocalDate date) {
        // Check if the date is not a Saturday or Sunday
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
    
    private static boolean isHoliday(LocalDate date) {
        // Check if the date is a holiday (06/19/2023)
        return date.equals(LocalDate.of(2023, 6, 19));
    }
}
