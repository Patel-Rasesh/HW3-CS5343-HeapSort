public class HeapSort {
	
	public int min(int value1, int value2) {
		/*
		 Accepts two arguments - value1 and value2 
		 Description - 			 compares value1 and value2
		 Returns - 				 smaller value
		 */
		if(value1 > value2) {
			return value2;
		}
		else {
			return value1;
		}
	}
	
	public void swapNodes(int[] arr, int childPointer, int index) {
		/*
		 Accepts three arguments - original array, and two indices 
		 Description - 			   swaps the array elements from the mentioned indices
		 Returns - 				   void
		 */
		int temp;
		temp = arr[childPointer];
		arr[childPointer] = arr[index];
		arr[index] = temp;
	}
	
	public void checkSwappingCondition(int arr[], int childPointer) {
		/*
		 Accepts two arguments - original array, and a pointer 
		 Description - 			 checks and swaps (parent and either of the children) if required
		 Returns - 				 void
		 */
		int index = childPointer;
		
		//Base condition for the recursive call
		if(childPointer*2 > (arr.length-1)) {
			return;
		}
		
		//Handing the scenario where a parent has only one child
		else if(childPointer*2 == (arr.length-1)){
			if(arr[childPointer] > arr[childPointer*2]) {
				index = childPointer*2;
				swapNodes(arr, childPointer, index);
				checkSwappingCondition(arr, index);
			}
			else {
				return;
			}
		}
		
		//Depending on value property of heap, swaps parent with respective child
		else{
			if(arr[childPointer] > min(arr[childPointer*2], arr[childPointer*2 + 1])) {
				if(arr[childPointer*2] > arr[childPointer*2 + 1]) {
					index = childPointer*2 + 1;
				}
				else {
					index = childPointer*2;
				}
				swapNodes(arr, childPointer, index);
				checkSwappingCondition(arr, index);
			}
			else {
				return;
			}
		}
	}
	
	public int[] makeMinHeap(int arr[], int mainPointer) {
		/*
		 Accepts two arguments - original array and a pointer 
		 Description - 			 makes a min-heap from array representation (Floyd's algorithm) 
		 Returns - 				 new array with array representation of min-heap
		 */
		if(mainPointer >= 0) {
			int childPointer = mainPointer;
			checkSwappingCondition(arr, childPointer);
			makeMinHeap(arr, mainPointer-1);
		}

		//Appending length of array at zero index
		int a = arr.length;
		int[] arrHeap = new int[a+1];
		arrHeap[0] = arr.length;
		for(int i=1; i<=arr.length;i++) {
			arrHeap[i]=arr[i-1];
		}
		return arrHeap;
	}
	
	public void percolateDown(int arr[], int begin, int n) {
		/*
		 Accepts three arguments - new array, a pointer, and dynamic length of array 
		 Description - 			   percolate a parent down in case of mismatch in value property
		 Returns - 				   void
		 */
		int pointer = begin;
		
		//Base condition for the recursive call
		if(begin*2 > n) {
			return; 
		}
		
		//Handing when a parent is having only one child
		else if(begin*2 == n){
			if(arr[begin] > arr[begin*2]){
				pointer = begin*2;
				swapNodes(arr, begin, pointer);
				percolateDown(arr, pointer, n);
			}
			else {
				return;
			}
		}
		
		//Depending on value property of heap, swaps parent with respective child
		else {
			if(arr[begin] > min(arr[begin*2], arr[begin*2+1])){
				if(arr[begin*2] > arr[begin*2 + 1]) {
					pointer = begin*2 + 1;
				}
				else {
					pointer = begin*2;
				}
				swapNodes(arr, begin, pointer);
				percolateDown(arr, pointer, n);
			}
			else {
				return;
			}
		}
	}
	
	public void heapSort(int arr[], int n) {
		/*
		 Accepts two arguments - new array and length of the array 
		 Description - 			 sorts new array using Heapsort algorithm
		 Returns - 				 void
		 */
		if(n == 1) {
			return;
		}
		
		//First unconditional swap between arr[1] and last element. Subsequently decreasing size of array.
		swapNodes(arr, 1, n);
		n = n-1;
		int begin = 1;
		percolateDown(arr, begin, n);
		heapSort(arr, n);
	}
	
}