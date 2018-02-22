package com.sorting.java.insertionsort;

public class MergeSort {
	
	private int[] theArray;
	
	MergeSort(int[] theArray) {
		this.theArray = theArray;
	}

	public void sort() {
		mergeSort(new int[theArray.length], 0, theArray.length - 1);
	}

	private void mergeSort(int[] workingCopyArray, int lowerBound, int upperBound) {

		if (lowerBound < upperBound) {

			mergeSort(workingCopyArray, lowerBound, midBound(lowerBound, upperBound));
			mergeSort(workingCopyArray, midBound(lowerBound, upperBound) + 1, upperBound);
			merge(workingCopyArray, lowerBound, midBound(lowerBound, upperBound) + 1, upperBound);

		} else {
			return;
		}
	}

	private int midBound(int lowerBound, int upperBound) {

		return (lowerBound + upperBound) / 2;
	}

	private void merge(int[] workingCopyArray, int lowerBound, int midBound, int upperBound) {
		
		int j = 0;
		int lowPtr = lowerBound;
		int midPtr = midBound-1;
		int numOfElements = upperBound - lowerBound +1;
		
		while(lowerBound <=midPtr && midBound<=upperBound) {
			
			if( theArray[lowerBound] < theArray[midBound]) {
				workingCopyArray[j++] = theArray[lowerBound++];
			} else {
				workingCopyArray[j++] = theArray[midBound++];
				
			}
		}
		
		while(lowerBound <= midPtr) {
			workingCopyArray[j++] = theArray[lowerBound++];
		}

		while(midBound<=upperBound) {
			workingCopyArray[j++] = theArray[midBound++];
		}
		
		for(int i =0; i<numOfElements; i++) {
			theArray[lowPtr+i] = workingCopyArray[i];
		}
	}

	public void display() {
		
		for(int i=0; i<theArray.length; i++) {
			System.out.print(theArray[i]+",");
		}
		
	}
	
	public static void main(String[] args) {
		
		int [] arrayToSort = {12,10,5};
		
		MergeSort mergeSort = new MergeSort(arrayToSort);
		mergeSort.display();
		mergeSort.sort();
		mergeSort.display();
	}
}
