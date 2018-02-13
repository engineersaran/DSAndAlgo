package com.sorting.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertionSort {

	public static final List<Integer> sort(List<Integer> unsortedList) {

		List<Integer> sortedList = unsortedList;

		for (int j = 0; j < sortedList.size(); j++) {

			Integer key = sortedList.get(j);
			int i = j-1;
			
			while(i>-1 && sortedList.get(i) > key) {
				
				sortedList.set(i+1, sortedList.get(i));
				i=i-1;
				sortedList.set(i+1, key);
			}
		}
		return sortedList;
	}
	
	public static void main(String[] args) {
		
		List<Integer> unsortedList = new ArrayList<>();
		
		for(int i =1; i< 10; i++) {
			unsortedList.add(new Random().nextInt(20));
		}
		
		System.out.println("Before Sorting");
		unsortedList.forEach(System.out::println);
		
		System.out.println("After Sorting");
		InsertionSort.sort(unsortedList).forEach(System.out::println);
		
	}

}
