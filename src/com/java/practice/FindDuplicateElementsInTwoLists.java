package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateElementsInTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers1 = Arrays.asList(4,5,1,3,7,1,8,2,9,2,8);
		List<Integer> numbers2 = Arrays.asList(0,7,1,2,8,1,5,5,3,4,6);
		System.out.println(findDuplicateElements2(numbers1, numbers2));
//		findDuplicateElements2(numbers1, numbers2);
	}
	
	// contains() method implementation
	private static Set<Integer> findDuplicateElements1(List<Integer> numbers1, List<Integer> numbers2) {
		// TODO Auto-generated method stub
		Set<Integer> duplicates = new HashSet<>();
		for(int number : numbers2) {
			if(numbers1.contains(number)) {
				duplicates.add(number);
			}
		}
		return duplicates; 
	}
	
	// retainAll() method implementation
	private static List<Integer> findDuplicateElements2(List<Integer> numbers1, List<Integer> numbers2) {
		// TODO Auto-generated method stub
		List<Integer> li1 = new ArrayList<>(numbers1);
		List<Integer> li2 = new ArrayList<>(numbers2);
		li1.retainAll(li2);
		return li1; 
	}

}
