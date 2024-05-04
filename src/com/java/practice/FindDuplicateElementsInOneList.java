package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElementsInOneList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(4,5,1,3,7,1,8,2,9,2,8);
		System.out.println(findDuplicateElements2(numbers));
		
	}
	
	// Collectors.counting() implementation
	private static <T> Set<T> findDuplicateElements1(List<T> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream()
		.collect(Collectors.groupingBy(
				Function.identity(),
				Collectors.counting()
				))
		.entrySet()
		.stream()
		
		.filter(e -> e.getValue() > 1)
		.map(Map.Entry::getKey)
		
		.collect(Collectors.toSet());
		
	}
	
	// Collections.frequency() implementation
	private static <T> Set<T> findDuplicateElements2(List<T> numbers) {
		// TODO Auto-generated method stub
		return numbers.stream()
		.filter(e -> Collections.frequency(numbers, e) > 1)
		.collect(Collectors.toSet());
		
	}
	
	

}
