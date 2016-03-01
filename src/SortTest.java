import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortTest {
	int[] testArr = {3, 5, 2, 6, 0, -100, -3};
	int[] sortedTestArr = {-100, -3, 0, 2, 3, 5, 6};
	
	int[] testArr2 = {Integer.MAX_VALUE, 8, 4, Integer.MIN_VALUE};
	int[] sortedTestArr2 = {Integer.MIN_VALUE, 4, 8, Integer.MAX_VALUE};
	
	int[] testArr3 = {4, 3, 4, 5, -30};
	int[] sortedTestArr3 = {-30, 3, 4, 4, 5};

	//generic sorting test - helper method
	private void sortingTest(int[] test, int[] sortedTest, String sortType){
		int[] arr = Arrays.copyOf(test, test.length);
		
		if(sortType == "selection") Sort.selectionSort(arr);
		else if(sortType == "insertion") Sort.insertionSort(arr);
		else if(sortType == "merge") Sort.mergeSort(arr);
		
		assertArrayEquals(arr, sortedTest);
	}

	//selection sort tests
	@Test
	public void selectionTest1(){
		sortingTest(testArr, sortedTestArr, "selection");
	}
	
	@Test
	public void selectionTest2(){
		sortingTest(testArr2, sortedTestArr2, "selection");
	}
	
	@Test
	public void selectionTest3(){
		sortingTest(testArr3, sortedTestArr3, "selection");
	}
	
	
	//insertion sort tests
	@Test
	public void insertionTest1(){
		sortingTest(testArr, sortedTestArr, "insertion");
	}
	
	@Test
	public void insertionTest2(){
		sortingTest(testArr2, sortedTestArr2, "insertion");
	}
	
	@Test
	public void insertionTest3(){
		sortingTest(testArr3, sortedTestArr3, "insertion");
	}
	
	@Test
	public void mergeTest1(){
		sortingTest(testArr, sortedTestArr, "merge");
	}
	
	@Test
	public void mergeTest2(){
		sortingTest(testArr2, sortedTestArr2, "merge");
	}
	
	@Test
	public void mergeTest3(){
		sortingTest(testArr3, sortedTestArr3, "merge");
	}
	
}