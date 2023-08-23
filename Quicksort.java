import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quicksort {
	public static int findK(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        return quickselect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickselect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickselect(arr, left, pivotIndex - 1, k);
        } else {
            return quickselect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = (left + right) / 2;
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, right);

        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);

        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
    	//System.out.println(Arrays.toString(arr));
    	
    	System.out.println("Please enter a value of k: ");
    	
    	int k = scanner.nextInt();
    	
    	int result = findK(arr, k);
    	
        System.out.println("Result: " + result + " , sorted input array: " + Arrays.toString(arr));
    	
        
        long milliEndTime = System.currentTimeMillis();
        long duration = (milliEndTime - milliStartTime); 
      
        System.out.println("Time: " + duration + " milliseconds" );
    }
}
