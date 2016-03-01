import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args){
		int[] list1 = {1, 6, 7, 10, -3, -2, 6, 9}; 
		int[] merged = new int[list1.length];
		
		merge(list1, merged, 0, 4, 7);
		printArray(merged);
	}
	
	private static void printArray(int[] arr){
		
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static void selectionSort(int[] arr){
		
		for(int i = 0; i < arr.length; i ++){
			int smallest = findSmallest(arr, i);
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
	}
	
	private static int findSmallest(int[] arr, int startIndex) {
		int smallest = Integer.MAX_VALUE;
		int smallestIndex = -1;

		for (int i = startIndex; i < arr.length; i++) {
			if (arr[i] <= smallest) {
				smallest = arr[i];
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) { //loop through array
			int last = i - 1; //get the index before you
	
			while (last != -1 && arr[last] > arr[last + 1]) {

				int temp = arr[last];
				arr[last] = arr[last + 1];
				arr[last + 1] = temp;
				last--;
			}
		}
	}
	
	/**
	 * bugs: didn't get the last iteration
	 * 
	 */
	public static void merge(int[] a, int[] temp, int list1min, int list2min, int list2end){
		int counter = 0;
		
		while(list2min <= list2end){
			if(a[list1min] <= a[list2min]){
				temp[counter] = a[list1min];
				list1min ++;
			} else{
				temp[counter] = a[list2min];
				list2min++;
			}
			
			counter ++;
		}
		
		a = Arrays.copyOfRange(temp, list1min, list2end);
	}
	
	
	public static void mergeSort(int[] arr){
		
	}
}