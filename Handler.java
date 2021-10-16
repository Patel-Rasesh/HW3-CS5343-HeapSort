
public class Handler {
	public static void main(String[] arg) {
		HeapSort heapSortObj = new HeapSort();
		int[] arr = {12, 123, 4, 15, 6, 1, 354, 71, 39, 5, 2, 67, 432, 556, 8};
		int [] arrHeap = {};
		System.out.println("Before converting the array to a Min Heap -");
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		arrHeap = heapSortObj.makeMinHeap(arr, (arr.length-1)/2);
		System.out.println();
		System.out.println("\nAfter converting the array in a Min Heap - ");
		for(int i =0; i<arrHeap.length; i++) {
			System.out.print(arrHeap[i]+" ");
		}
		System.out.println();
		System.out.println("In above array representation, first element is length of the array");
		heapSortObj.heapSort(arrHeap, arrHeap.length-1);
		System.out.println("\nAfter heapsorting in a descending manner the array will look like -");
		for(int i =1; i<arrHeap.length; i++) {
			System.out.print(arrHeap[i]+" ");
		}
	}
}
