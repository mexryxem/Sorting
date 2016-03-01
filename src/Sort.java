
public class Sort {
	
	public static void main(String[] args){
		int[] list = {5, 7, 1, 9, 2, 8};
		
		insertionSort(list);
		printArray(list);
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
	
	public static void mergeSort(int[] arr){
		
	}
}