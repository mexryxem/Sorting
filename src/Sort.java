import java.util.Arrays;

public class Sort {
	
	public static void main(String[] args){
		int[] half1 = {1, 3, 5, 7};
		int[] half2 = {2, 4, 6, 8};
		//int[] merged = new int[half.length];
		
		//merge2(half, merged, 0, 4, half.length);
		printArray(merge3(new int[half1.length + half2.length], half1, half2));
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
	
	public static int[] merge3(int[] merged, int[]left, int[] right){
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		int mergedIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length){
			
			if(leftIndex < left.length && rightIndex < right.length && left[leftIndex] < right[rightIndex]){
				merged[mergedIndex] = left[leftIndex];
				leftIndex ++;
			} else if(leftIndex < left.length && rightIndex < right.length && right[rightIndex] < left[leftIndex]){
				merged[mergedIndex] = right[rightIndex];
				rightIndex ++;
			}
			
			mergedIndex ++;
			
		}
		
		return merged;
		
	}
	
	public static void merge2(int[] a, int[] temp, int list1min, int list2min, int list2end){
		
		int smallest1 = list1min;
		int smallest2 = list2min;
		int end = list2end;
		
		int tempCounter = 0;
		
		while(smallest1 < list2min || smallest2 < end){
			System.out.println(smallest1 + "\t" + smallest2);
			
			if(a[smallest1] < a[smallest2]){
				
				temp[tempCounter] = a[smallest1];
				smallest1 ++;
				
			} else if(a[smallest2] < a[smallest1]){
				
				temp[tempCounter] = a[smallest2];
				if(smallest2 + 1 < end) smallest2++;
				
			}
			
			printArray(temp);
			tempCounter++;
			
			
			
			
			
		}
		
		
		
		
		//a = Arrays.copyOfRange(temp, list1min, list2end);
		
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
		
		//a = Arrays.copyOfRange(temp, list1min, list2end);
		for(int i = 0; i < a.length; i ++) a[i] = temp[i];
	}
	
	
	public static void mergeSort(int[] a, int[] temp, int left, int right){
		if(right <= left + 1) return;
		
		int mid = left + (right - left)/2;
		mergeSort(a, temp, left, mid);
		mergeSort(a, temp, mid, right);
		merge(a, temp, left, mid, right);
		
	}
}