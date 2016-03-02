import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args){
		int[] list1 = {5, 1, 9, 7, 3};
		int[] half = {1,2,3,4, -5, -4, -3, -2, -1};
		int[] merged = new int[half.length];
		
		merge(half, merged, 0, 4, half.length);
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
	 * array index out of bounds
	 * 
	 */
	public static void merge(int[] a, int[] temp, int list1min, int list2min, int list2end){
		int counter = 0;
		
		while(list2min < list2end || list1min < list2min){
			
			if(a[list1min] < a[list2min] || a[list2min] < a[list2end]) {
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
	
	
	public static void mergeSort(int[] a, int[] temp, int left, int right){
		if(right <= left + 1) return;
		
		int mid = left + (right - left)/2;
		mergeSort(a, temp, left, mid);
		mergeSort(a, temp, mid, right);
		merge(a, temp, left, mid, right);
		
	}
}