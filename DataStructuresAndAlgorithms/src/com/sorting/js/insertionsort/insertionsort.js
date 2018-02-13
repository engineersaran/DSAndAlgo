function insertionSort(unsortedList) {

	for(var j=0; j<unsortedList.length; j++) {
		
		var key = unsortedList[j];
		var i = j-1;
		
		while(i>-1 && unsortedList[i] > key) {
			
			unsortedList[i+1] = unsortedList[i];
			i=i-1;
			unsortedList[i+1] = key;
		}
	}
}
