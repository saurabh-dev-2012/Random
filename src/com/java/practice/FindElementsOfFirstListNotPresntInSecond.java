package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindElementsOfFirstListNotPresntInSecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers1 = Arrays.asList(4,5,1,3,7,1,8,2,9,2,8);
		List<Integer> numbers2 = Arrays.asList(0,7,1,2,8,1,5,5,3,4,6);
		System.out.println("First List Difference: " + getDifferenceFromFirstListRemoveAll(numbers1, numbers2));
		System.out.println("Second List Difference: " + getDifferenceFromSecondList(numbers1, numbers2));
	}
	
	// contains() implementation
	private static Set<Integer> getDifferenceFromFirstList(List<Integer> numbers1, List<Integer> numbers2) {
		// TODO Auto-generated method stub
		return numbers1.stream()
		.filter(e -> !numbers2.contains(e))
		.collect(Collectors.toSet());
	}
	
	// contains() implementation
	private static Set<Integer> getDifferenceFromSecondList(List<Integer> numbers1, List<Integer> numbers2) {
		// TODO Auto-generated method stub
		return numbers2.stream()
		.filter(e -> !numbers1.contains(e))
		.collect(Collectors.toSet());
	}
	
	// RemoveAll() implementation
	private static List<Integer> getDifferenceFromFirstListRemoveAll(List<Integer> numbers1, List<Integer> numbers2) {
		// TODO Auto-generated method stub
		List<Integer> li1 = new ArrayList<>(numbers1);
		List<Integer> li2 = new ArrayList<>(numbers2);
		li1.removeAll(li2);
		return li1;
	}

}
