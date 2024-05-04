package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Java8Onwards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Operations op = (x,y) -> x + y;
		
		System.out.println("Lambda Expression: " + op.sum(3, 7));
		
		String[] strings = {"java", "microservice", "number", "geeksforgeeks", "systemdesign architecture"};
		int[] values = {1, 11, 21, 29, 34, 59, 49, 17, 23};
//		System.out.println(findLongestLengthStringNewLogic(strings));
		System.out.println(findStringsStartingWith(values, "3"));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Vivek", 1200);
		map.put("Aniket", 1100);
		map.put("Abhijit", 1600);
		map.put("Amit", 1100);
		map.put("Saurabh", 1800);
		map.put("Saket", 1400);
		map.put("Virat", 1800);
		map.put("Pratik", 1400);
		map.put("Sarthak", 1600);
		
		Map<String, Map<Integer, String>> mapOfMap = new HashMap<>();
        mapOfMap.put("Key1", Map.of(1, "Value1", 2, "Value2"));
        mapOfMap.put("Key2", Map.of(3, "Value3", 4, "Value4"));
        mapOfMap.put("Key3", Map.of(5, "Value5", 6, "Value6"));
        
        Map<String, List<String>> mapOfList = convertMapOfMapToMapOfList(mapOfMap);
        
        mapOfList.forEach((key, list) -> System.out.println("Key: " + key + " List of Values: " + list));
		
		System.out.println(findNthHighestSalaryOfEmployee(4,map));
	}
	
	private static String findLongestLengthString(String[] strings) {
		
		return Arrays.stream(strings)
		.reduce((s1,s2) -> (s1.length() > s2.length() ? s1 : s2))
		.get();
	}
	
	private static String findLongestLengthStringNewLogic(String[] strings) {
		
		
		return Arrays.stream(strings)
		.collect(Collectors.maxBy((s1,s2) -> s1.length()-s2.length()))
		.get();
	}
	
	private static List<String> findStringsStartingWith(int[] values, String startsWith) {
		
		return Arrays.stream(values)
		.mapToObj(v -> ""+v)
		.filter(v -> v.startsWith(startsWith))
		.collect(Collectors.toList());
		
	}
	
	private static Map.Entry<Integer, List<String>> findNthHighestSalaryOfEmployee(int n, Map<String, Integer> map) {
		
//		map.entrySet().stream()
//		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//		.collect(Collectors.toList())
//		.get(n-1);
		
			return map.entrySet().stream()
			.collect(Collectors.groupingBy(Map.Entry::getValue, 
					Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
			.entrySet().stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
			.collect(Collectors.toList())
			.get(n-1);
	}
	
	
	private static Map<String, List<String>> convertMapOfMapToMapOfList(Map<String, Map<Integer, String>> data) {
        
        return data.entrySet()
        .stream()
        .collect(Collectors.toMap(
        		
        		 Map.Entry::getKey,
        		 entry -> new ArrayList<>(entry.getValue().values())
        		
        ));
                
    }
	
	



}

interface Operations {
	int sum(int a, int b);
}
