import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class quicksortMM {

	public static int getK(int[] arr, int k) {
		 if (k > 0 && k <= arr.length) {
	            int[] sortedArr = quicksortMedianOfMedians(arr);
	            return sortedArr[k - 1];
	        }
	        return -1; // Invalid k value
	    }

	    public static int[] quicksortMedianOfMedians(int[] arr) {
	        if (arr.length <= 1) {
	            return arr;
	        }

	        // Select pivot using Median of Medians algorithm
	        int pivot = selectPivot(arr);

	        // Partition the array around the pivot
	        List<Integer> smaller = new ArrayList<>();
	        List<Integer> equal = new ArrayList<>();
	        List<Integer> larger = new ArrayList<>();
	        for (int element : arr) {
	            if (element < pivot) {
	                smaller.add(element);
	            } else if (element > pivot) {
	                larger.add(element);
	            } else {
	                equal.add(element);
	            }
	        }

	        // Recursively sort the smaller and larger partitions
	        int[] sortedSmaller = quicksortMedianOfMedians(smaller.stream().mapToInt(Integer::intValue).toArray());
	        int[] sortedLarger = quicksortMedianOfMedians(larger.stream().mapToInt(Integer::intValue).toArray());

	        // Concatenate the sorted partitions and the equal elements
	        int[] sortedArr = new int[sortedSmaller.length + equal.size() + sortedLarger.length];
	        int index = 0;
	        for (int num : sortedSmaller) {
	            sortedArr[index++] = num;
	        }
	        for (int num : equal) {
	            sortedArr[index++] = num;
	        }
	        for (int num : sortedLarger) {
	            sortedArr[index++] = num;
	        }

	        return sortedArr;
	    }

	    public static int selectPivot(int[] arr) {
	        if (arr.length <= 5) {
	            Arrays.sort(arr);
	            return arr[arr.length / 2];
	        }

	        int chunkSize = 5;
	        int numChunks = (int) Math.ceil((double) arr.length / chunkSize);
	        int[] medians = new int[numChunks];

	        for (int i = 0; i < numChunks; i++) {
	            int start = i * chunkSize;
	            int end = Math.min(start + chunkSize - 1, arr.length - 1);
	            int[] chunk = Arrays.copyOfRange(arr, start, end + 1);
	            medians[i] = selectPivot(chunk);
	        }

	        return selectPivot(medians);
	    }

    public static void main(String[] args) {
    	long milliStartTime = System.currentTimeMillis();
    	Random r = new Random();
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter the size of the array: ");
    	int size = scanner.nextInt();
    	
    	int arr[] = new int[size];
    	for (int i =0; i< size; i++) {
    		arr[i] = r.nextInt(11);
    	}
    	
    	
    	System.out.println("Please enter a value of k: ");
    	
    	int k = scanner.nextInt();
    	
    	int result = getK(arr, k);
    	
    	
        System.out.println("Result: " + result );
    	
        
        long milliEndTime = System.currentTimeMillis();
        long duration = (milliEndTime - milliStartTime); 
      
        System.out.println("Time: " + duration + " milliseconds" );
    }
}
